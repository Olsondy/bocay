package priv.bocayouth.common.mobile.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import priv.bocayouth.common.mobile.config.properties.WechatProperties;

/**
 * @author Olsond
 * @date 2025/8/13 22:46
 * @description
 */
@AutoConfiguration
@EnableConfigurationProperties(WechatProperties.class)
public class WechatConfig {

}
