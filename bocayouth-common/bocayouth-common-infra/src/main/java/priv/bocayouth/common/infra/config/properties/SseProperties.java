package priv.bocayouth.common.infra.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * SSE 配置项
 *
 * @author Lion Li
 */
@Data
@ConfigurationProperties("sse")
public class SseProperties {

    private Boolean enabled;

    /**
     * 路径
     */
    private String path;
}
