package priv.bocayouth.common.base.handle;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.extern.slf4j.Slf4j;
import priv.bocayouth.common.base.annotation.Conversion;
import priv.bocayouth.common.base.feat.service.ConversionInterface;
import priv.bocayouth.common.core.utils.StringUtils;
import priv.bocayouth.common.core.utils.reflect.ReflectUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 转换处理器
 *
 * @author Lion Li
 */
@Slf4j
public class ConversionHandler extends JsonSerializer<Object> implements ContextualSerializer {

    /**
     * 全局转换实现类映射器
     */
    public static final Map<String, ConversionInterface<?>> TRANSLATION_MAPPER = new ConcurrentHashMap<>();

    private Conversion conversion;

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ConversionInterface<?> trans = TRANSLATION_MAPPER.get(conversion.type());
        if (ObjectUtil.isNotNull(trans)) {
            // 如果映射字段不为空 则取映射字段的值
            if (StringUtils.isNotBlank(conversion.mapper())) {
                value = ReflectUtils.invokeGetter(gen.currentValue(), conversion.mapper());
            }
            // 如果为 null 直接写出
            if (ObjectUtil.isNull(value)) {
                gen.writeNull();
                return;
            }
            Object result = trans.translation(value, conversion.other());
            gen.writeObject(result);
        } else {
            gen.writeObject(value);
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        Conversion conversion = property.getAnnotation(Conversion.class);
        if (Objects.nonNull(conversion)) {
            this.conversion = conversion;
            return this;
        }
        return prov.findValueSerializer(property.getType(), property);
    }
}
