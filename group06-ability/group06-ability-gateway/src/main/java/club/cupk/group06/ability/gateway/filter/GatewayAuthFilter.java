package club.cupk.group06.ability.gateway.filter;

import club.cupk.group06.common.core.util.RedisUtil;
import club.cupk.group06.common.web.response.ResponseVO;
import club.cupk.group06.common.web.response.ResultCode;
import club.cupk.group06.data.system.domain.User;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson.JSON;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Icyの模块
 *
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class GatewayAuthFilter implements GlobalFilter, Ordered {

    private static List<String> whitelist = new ArrayList<>();

    @Autowired
    private RedisUtil redisUtil;

    static {
        whitelist.add("/auth/**");
        whitelist.add("/test/**");
        whitelist.add("/**");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String requestUrl = exchange.getRequest().getPath().value();
        AntPathMatcher pathMatcher = new AntPathMatcher();
        // 白名单放行
        for (String url : whitelist) {
            if (pathMatcher.match(url, requestUrl)) {
                return chain.filter(exchange);
            }
        }

        String token = getToken(exchange);
        if (StringUtils.isEmpty(token)) {
            return buildReturnMono("未认证", exchange);
        }

        String uid;
        try {
            // 解析token
            uid = (String) JWTUtil.parseToken(token).getPayload("uid");
            // alibaba的JsonObject，只能用Object接收，否则报强转异常
            Object json = redisUtil.get("login:" + uid);
            // 读redis
            if (json == null) {
                // 用户未登录。不能抛异常，Filter层在Advice之上。
                return buildReturnMono("用户未登录", exchange);
            }

            User user = (User)json;

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        } catch (Exception e) {
            // token不合法。不能抛异常，Filter层在Advice之上。
            return buildReturnMono("认证非法", exchange);
        }

        ServerHttpRequest.Builder requestBuilder = exchange.getRequest().mutate();
        requestBuilder.headers(k -> k.set("userId", uid));
        ServerHttpRequest request = requestBuilder.build();
        exchange.mutate().request(request).build();
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Nullable
    private String getToken(@NotNull ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if (token == null || token.trim().length() == 0) {
            return null;
        }
        return token;
    }

    private Mono<Void> buildReturnMono(String error, ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        Map<String,Object> map = new HashMap<>();
        map.put("code",403);
        map.put("message",error);

        String jsonString = JSON.toJSONString(map);
        byte[] bits = jsonString.getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}
