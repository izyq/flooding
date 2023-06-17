package club.cupk.group06.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 安全框架配置
 * @author Icy
 * @version 1.0.0
 * @since 版本
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private String privateKey;

}
