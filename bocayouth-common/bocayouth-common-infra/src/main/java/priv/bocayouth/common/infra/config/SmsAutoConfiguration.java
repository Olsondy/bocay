package priv.bocayouth.common.infra.config;

import org.dromara.sms4j.api.dao.SmsDao;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import priv.bocayouth.common.infra.feat.dao.PlusSmsDao;
import priv.bocayouth.common.infra.feat.handler.SmsExceptionHandler;

/**
 * 短信配置类
 *
 * @author Feng
 */
@AutoConfiguration(after = {RedisAutoConfiguration.class})
public class SmsAutoConfiguration {

    @Primary
    @Bean
    public SmsDao smsDao() {
        return new PlusSmsDao();
    }

    /**
     * 异常处理器
     */
    @Bean
    public SmsExceptionHandler smsExceptionHandler() {
        return new SmsExceptionHandler();
    }

}
