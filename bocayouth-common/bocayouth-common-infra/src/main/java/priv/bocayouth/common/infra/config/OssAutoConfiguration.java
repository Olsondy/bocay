package priv.bocayouth.common.infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.bocayouth.common.infra.feat.client.OssClient;

/**
 * @author Olsond
 * @date 2025/9/22
 * @description
 */
@Configuration
public class OssAutoConfiguration {
    @Value("${spring.servlet.multipart.location}")
    private String multipartLocation;

    @Bean
    public OssClient ossClient() {
        OssClient ossClient = new OssClient();
        ossClient.setMultipartLocation(multipartLocation);
        return ossClient;
    }
}
