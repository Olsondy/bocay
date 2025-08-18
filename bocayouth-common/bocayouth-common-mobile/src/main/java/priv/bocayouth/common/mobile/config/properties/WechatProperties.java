package priv.bocayouth.common.mobile.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Olsond
 * @date 2025/8/13 22:47
 * @description
 */
@Data
@ConfigurationProperties(prefix = "wechat")
public class WechatProperties {

    private String domain;

    private String appId;

    private String appSecret;

    private Address urlAddress;

    @Data
    public static class Address {

        private String code2Login;
    }
}
