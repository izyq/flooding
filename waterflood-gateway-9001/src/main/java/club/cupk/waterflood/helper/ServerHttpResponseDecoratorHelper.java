package club.cupk.waterflood.helper;

import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.factory.rewrite.CachedBodyOutputMessage;
import org.springframework.cloud.gateway.support.BodyInserterContext;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR;

/**
 * Icyの模块
 *
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
public class ServerHttpResponseDecoratorHelper {
    public static ServerHttpResponseDecorator build(ServerWebExchange exchange,
                                                    MyRewriteFunction<byte[], byte[]> rewriteFunction) {
        return new ServerHttpResponseDecorator(exchange.getResponse()) {
            @Override
            @NotNull
            public Mono<Void> writeWith(@NotNull Publisher<? extends DataBuffer> body) {
                String originalResponseContentType = exchange
                        .getAttribute(ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR);
                HttpHeaders httpHeaders = new HttpHeaders();
                // explicitly add it in this way instead of
                // 'httpHeaders.setContentType(originalResponseContentType)'
                // this will prevent exception in case of using non-standard media
                // types like "Content-Type: image"
                httpHeaders.add(HttpHeaders.CONTENT_TYPE,
                        originalResponseContentType);


                ClientResponse clientResponse = prepareClientResponse(body,
                        httpHeaders);

                MediaType contentType = httpHeaders.getContentType();
                // TODO: 为void方法包装返回
                if (contentType != null && !MediaType.APPLICATION_JSON.isCompatibleWith(contentType)) {
                    return super.writeWith(body);
                }
                // TODO: flux or mono
                Mono<byte[]> modifiedBody = clientResponse.bodyToMono(byte[].class)
                        .flatMap(rewriteFunction);


                return bodyInsert(this, exchange, modifiedBody);
            }

            @Override
            @NotNull
            public Mono<Void> writeAndFlushWith(
                    @NotNull Publisher<? extends Publisher<? extends DataBuffer>> body) {
                return writeWith(Flux.from(body).flatMapSequential(p -> p));
            }

            private ClientResponse prepareClientResponse(
                    Publisher<? extends DataBuffer> body, HttpHeaders httpHeaders) {
                ClientResponse.Builder builder;
                builder = ClientResponse
                        .create(Objects.requireNonNull(exchange.getResponse().getStatusCode()));
                return builder.headers(headers -> headers.putAll(httpHeaders))
                        .body(Flux.from(body)).build();
            }
        };
    }

    public static Mono<Void> bodyInsert(ServerHttpResponseDecorator decorator,
                                        ServerWebExchange exchange,
                                        Mono<byte[]> modifiedBody) {
        BodyInserter<Mono<byte[]>, ReactiveHttpOutputMessage> bodyInserter = BodyInserters.fromPublisher(modifiedBody,
                byte[].class);
        CachedBodyOutputMessage outputMessage = new CachedBodyOutputMessage(
                exchange, exchange.getResponse().getHeaders());
        return bodyInserter.insert(outputMessage, new BodyInserterContext())
                .then(Mono.defer(() -> {
                    Flux<DataBuffer> messageBody = outputMessage.getBody();
                    HttpHeaders headers = decorator.getDelegate().getHeaders();
                    if (!headers.containsKey(HttpHeaders.TRANSFER_ENCODING)) {
                        messageBody = messageBody.doOnNext(data -> headers
                                .setContentLength(data.readableByteCount()));
                    }
                    // TODO: fail if isStreamingMediaType?
                    return decorator.getDelegate().writeWith(messageBody);
                }));
    }

    public interface MyRewriteFunction<T, R>
            extends Function<T, Mono<R>> {

    }
}