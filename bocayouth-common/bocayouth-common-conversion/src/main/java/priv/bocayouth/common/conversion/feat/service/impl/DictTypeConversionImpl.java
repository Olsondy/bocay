package priv.bocayouth.common.conversion.feat.service.impl;

import lombok.AllArgsConstructor;
import priv.bocayouth.common.conversion.annotation.ConversionType;
import priv.bocayouth.common.conversion.constant.ConversionConstant;
import priv.bocayouth.common.conversion.feat.service.ConversionInterface;
import priv.bocayouth.common.core.feat.service.DictService;
import priv.bocayouth.common.core.utils.StringUtils;

/**
 * 字典转换实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@ConversionType(type = ConversionConstant.DICT_TYPE_TO_LABEL)
public class DictTypeConversionImpl implements ConversionInterface<String> {

    private final DictService dictService;

    @Override
    public String conversion(Object key, String other) {
        if (key instanceof String dictValue && StringUtils.isNotBlank(other)) {
            return dictService.getDictLabel(other, dictValue);
        }
        return null;
    }
}
