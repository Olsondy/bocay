package priv.bocayouth.common.conversion.feat.service;


import priv.bocayouth.common.conversion.annotation.ConversionType;

/**
 * 转换接口 (实现类需标注 {@link ConversionType} 注解标明转换类型)
 *
 * @author Lion Li
 */
public interface ConversionInterface<T> {

    /**
     * 转换
     *
     * @param key   需要被转换的键(不为空)
     * @param other 其他参数
     * @return 返回键对应的值
     */
    T conversion(Object key, String other);
}
