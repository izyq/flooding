package club.cupk.waterflood.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
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
public class IgnoreAuthFilter extends AbstractGatewayFilterFactory<IgnoreAuthFilter.Config> {


    public IgnoreAuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new InnerFilter(config);
    }

    /**
     * 创建一个内部类，来实现2个接口，指定顺序
     * 这里通过Ordered指定优先级
     */
    private static class InnerFilter implements GatewayFilter, Ordered {

        private final Config config;

        InnerFilter(Config config) {
            this.config = config;
        }

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            if (config.isIgnoreGlobalFilter()) {
                exchange.getAttributes().put(JsonResponseWrapperFilter.IS_IGNORE_AUTH_FILTER, true);
            }
            return chain.filter(exchange);
        }

        //这里优先级要大于全局过滤器
        @Override
        public int getOrder() {
            return -1000;
        }
    }

    @Data
    public static class Config {
        boolean ignoreGlobalFilter;
    }

    /**
     * 这个name方法 用来在yml配置中指定对应的过滤器名称
     **/
    @Override
    public String name() {
        return "IgnoreAuthFilter";
    }

}
