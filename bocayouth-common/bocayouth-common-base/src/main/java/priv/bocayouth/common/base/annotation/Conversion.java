package priv.bocayouth.common.base.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import priv.bocayouth.common.base.handle.ConversionHandler;

import java.lang.annotation.*;

/**
 * 通用转换注解
 *
 * @author Lion Li
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
@JacksonAnnotationsInside
@JsonSerialize(using = ConversionHandler.class)
public @interface Conversion {

    /**
     * 类型 (需与实现类上的 {@link ConversionType} 注解type对应)
     * <p>
     * 默认取当前字段的值 如果设置了 @{@link Conversion#mapper()} 则取映射字段的值
     */
    String type();

    /**
     * 映射字段 (如果不为空则取此字段的值)
     */
    String mapper() default "";

    /**
     * 其他条件 例如: 字典type(sys_user_sex)
     */
    String other() default "";

}
