package club.cupk.waterflood.filter;

import club.cupk.waterflood.domain.vo.ResultCode;
import club.cupk.waterflood.helper.ServerHttpResponseDecoratorHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.NettyWriteResponseFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Icyの模块
 *
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
@Slf4j
public class JsonResponseWrapperFilter implements ComplexFilter {

    public static final String IS_IGNORE_AUTH_FILTER = "ignore";

    @Override
    public int getOrder() {
        return NettyWriteResponseFilter.WRITE_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //操作针对某些路由跳过全局过滤器
        if (exchange.getAttributes().get(IS_IGNORE_AUTH_FILTER) != null) {
            return chain.filter(exchange);
        }
        //包装响应体
        ServerWebExchange newExchange = exchange.mutate().response(
                ServerHttpResponseDecoratorHelper.build(exchange, (originalBody) -> {
                    String requestUri = exchange.getRequest().getPath().pathWithinApplication().value();
                    MediaType responseMediaType = exchange.getResponse().getHeaders().getContentType();
                    log.info("Request [{}] response content-type is {}", requestUri, responseMediaType);
                    if (MediaType.APPLICATION_JSON.isCompatibleWith(responseMediaType)) {
                        return rewriteBody(exchange, originalBody);
                    } else {
                        return Mono.just(originalBody);
                    }
                })).build();
        return chain.filter(newExchange);
    }

    private Mono<byte[]> rewriteBody(ServerWebExchange exchange, byte[] originalBody) {
        HttpStatus originalResponseStatus = exchange.getResponse().getStatusCode();
        //将状态码统一重置为200，在这里重置才是终极解决办法
        log.debug("Response status code is {} , body is {}", originalResponseStatus, new String(originalBody));
        if (originalResponseStatus == HttpStatus.OK) {
            exchange.getResponse().setStatusCode(HttpStatus.OK);
            try {
                //只能parse出JSONObject、JSONArray、Integer、Boolean等类型，当是一个string但是非json格式则抛出异常
                Object jsonObject = JSON.parse(originalBody);
                //如果响应内容已经包含了errcode字段，则表示下游的响应体本身已经是统一结果体了，无需再包装
                if ((jsonObject instanceof JSONObject) && ((JSONObject) jsonObject).containsKey("errcode")) {
                    log.debug("服务响应体已经是统一结果体，无需包装");
                    return Mono.just(originalBody);
                } else {
                    return makeMono(R.ok(jsonObject));
                }
            } catch (Exception e) {
                log.error("解析下游响应体异常", e);
                return makeMono(R.ok(originalBody));
            }
        } else {
            //如果不是401和403异常则重置为200状态码
            if (!ArrayUtils.contains(new int[]{401, 403}, originalResponseStatus.value())) {
                exchange.getResponse().setStatusCode(HttpStatus.OK);
            }

            //响应异常的报文
            try {
                //只能parse出JSONObject、JSONArray、Integer、Boolean等类型，当是一个string但是非json格式则抛出异常
                Object jsonObject = JSON.parse(originalBody);
                //如果响应内容已经包含了errcode字段，则表示下游的响应体本身已经是统一结果体了
                if ((jsonObject instanceof JSONObject)) {
                    JSONObject jo = ((JSONObject) jsonObject);
                    if (jo.containsKey("errcode")) {
                        return Mono.just(originalBody);
                    } else if (jo.containsKey("status") && jo.containsKey("ResultCode")) {
                        int resultCode = jo.getIntValue("ResultCode");
                        String message = jo.getString("message");
                        return Mono.just(JSON.toJSONBytes(R.error(resultCode, message)
                                , SerializerFeature.WriteMapNullValue));
                    } else if ("404".equals(jo.getString("status"))) {
                        //下游返回了404
                        return Mono.just(JSON.toJSONBytes(R.error(
                                ResultCode.GATEWAY_DOWNSTREAM_RESOURCE_NOT_FOUND.getCode(),
                                ResultCode.GATEWAY_DOWNSTREAM_RESOURCE_NOT_FOUND.getMessage()
                        ), SerializerFeature.WriteMapNullValue));
                    } else if ("405".equals(jo.getString("status"))) {
                        //下游返回了405
                        return Mono.just(JSON.toJSONBytes(R.error(
                                ResultCode.METHOD_NOT_ALLOWED.getCode(),
                                ResultCode.METHOD_NOT_ALLOWED.getMessage()
                        ), SerializerFeature.WriteMapNullValue));
                    } else if ("415".equals(jo.getString("status"))) {
                        //下游返回了415
                        return Mono.just(JSON.toJSONBytes(R.error(
                                ResultCode.UNSUPPORTED_MEDIA_TYPE.getCode(),
                                ResultCode.UNSUPPORTED_MEDIA_TYPE.getMessage()
                        )));
                    } else {
                        //下游返回的包体是一个jsonobject，并不是规范的错误包体
                        return Mono.just(JSON.toJSONBytes(R.error(
                                ResultCode.GATEWAY_DOWNSTREAM_ERROR_INFO_FORMAT_ERROR.getCode(),
                                ResultCode.GATEWAY_DOWNSTREAM_ERROR_INFO_FORMAT_ERROR.getMessage(),
                                originalBody
                        ), SerializerFeature.WriteMapNullValue));
                    }
                } else {
                    //不是一个jsonobject，可能是一个jsonarray
                    return Mono.just(JSON.toJSONBytes(R.error(
                            ResultCode.GATEWAY_DOWNSTREAM_ERROR_INFO_FORMAT_ERROR.getCode(),
                            ResultCode.GATEWAY_DOWNSTREAM_ERROR_INFO_FORMAT_ERROR.getMessage(),
                            originalBody
                    ), SerializerFeature.WriteMapNullValue));
                }
            } catch (Exception e) {
                log.error("解析下游响应体异常", e);
                return Mono.just(JSON.toJSONBytes(R.error(
                        ResultCode.GATEWAY_DOWNSTREAM_ERROR_INFO_FORMAT_ERROR.getCode(),
                        ResultCode.GATEWAY_DOWNSTREAM_ERROR_INFO_FORMAT_ERROR.getMessage(),
                        originalBody
                ), SerializerFeature.WriteMapNullValue));
            }
        }
    }

    private Mono<byte[]> makeMono(R result) {
        return Mono.just(JSON.toJSONBytes(result, SerializerFeature.WriteMapNullValue));
    }
}
