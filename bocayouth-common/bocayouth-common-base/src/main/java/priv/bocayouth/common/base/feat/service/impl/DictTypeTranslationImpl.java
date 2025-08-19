package priv.bocayouth.common.base.feat.service.impl;

import lombok.AllArgsConstructor;
import priv.bocayouth.common.base.annotation.ConversionType;
import priv.bocayouth.common.base.constant.ConversionConstant;
import priv.bocayouth.common.base.feat.service.ConversionInterface;
import priv.bocayouth.common.core.feat.service.DictService;
import priv.bocayouth.common.core.utils.StringUtils;

/**
 * 字典转换实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@ConversionType(type = ConversionConstant.DICT_TYPE_TO_LABEL)
public class DictTypeTranslationImpl implements ConversionInterface<String> {

    private final DictService dictService;

    @Override
    public String translation(Object key, String other) {
        if (key instanceof String dictValue && StringUtils.isNotBlank(other)) {
            return dictService.getDictLabel(other, dictValue);
        }
        return null;
    }
}
