package club.cupk.group06.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 腾讯短信api配置
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "tencent-sms")
public class MessageConfig {

    private String secretId;

    private String secretKey;

    private String region;

    private String sdkAppId;

    private String signName;

    private String templateId;

    private Boolean enabled;

}
