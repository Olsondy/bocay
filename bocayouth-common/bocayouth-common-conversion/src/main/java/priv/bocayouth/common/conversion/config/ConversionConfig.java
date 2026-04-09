package priv.bocayouth.common.conversion.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import priv.bocayouth.common.conversion.annotation.ConversionType;
import priv.bocayouth.common.conversion.feat.service.ConversionInterface;
import priv.bocayouth.common.conversion.handle.ConversionBeanSerializerModifier;
import priv.bocayouth.common.conversion.handle.ConversionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 转换模块配置类
 *
 * @author Lion Li
 */
@Slf4j
@AutoConfiguration
public class ConversionConfig {

    @Autowired
    private List<ConversionInterface<?>> list;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        Map<String, ConversionInterface<?>> map = new HashMap<>(list.size());
        for (ConversionInterface<?> trans : list) {
            if (trans.getClass().isAnnotationPresent(ConversionType.class)) {
                ConversionType annotation = trans.getClass().getAnnotation(ConversionType.class);
                map.put(annotation.type(), trans);
            } else {
                log.warn(trans.getClass().getName() + " 转换实现类未标注 TranslationType 注解!");
            }
        }
        ConversionHandler.TRANSLATION_MAPPER.putAll(map);
        // 设置 Bean 序列化修改器
        objectMapper.setSerializerFactory(
            objectMapper.getSerializerFactory()
                .withSerializerModifier(new ConversionBeanSerializerModifier()));
    }

}
