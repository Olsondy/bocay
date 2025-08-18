package priv.bocayouth.common.base.annotation;

import priv.bocayouth.common.base.feat.service.ConversionInterface;

import java.lang.annotation.*;

/**
 * 转换类型注解 (标注到{@link ConversionInterface} 的实现类)
 *
 * @author Lion Li
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface ConversionType {

    /**
     * 类型
     */
    String type();

}
