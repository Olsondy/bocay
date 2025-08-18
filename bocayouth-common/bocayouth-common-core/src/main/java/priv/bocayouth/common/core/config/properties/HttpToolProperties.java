package priv.bocayouth.common.core.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "http.client")
public class HttpToolProperties {
    private int connectTimeout = 5000;
    private int readTimeout = 10000;
    private int writeTimeout = 10000;
    private int maxConnTotal = 200;
    private int maxConnPerRoute = 50;
}