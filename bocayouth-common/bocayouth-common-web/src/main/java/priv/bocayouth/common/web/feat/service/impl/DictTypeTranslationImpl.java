package priv.bocayouth.common.web.feat.service.impl;

import lombok.AllArgsConstructor;
import priv.bocayouth.common.web.annotation.TranslationType;
import priv.bocayouth.common.web.constant.TransConstant;
import priv.bocayouth.common.core.feat.core.DictService;
import priv.bocayouth.common.core.utils.StringUtils;
import priv.bocayouth.common.web.feat.service.TranslationInterface;

/**
 * 字典翻译实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@TranslationType(type = TransConstant.DICT_TYPE_TO_LABEL)
public class DictTypeTranslationImpl implements TranslationInterface<String> {

    private final DictService dictService;

    @Override
    public String translation(Object key, String other) {
        if (key instanceof String dictValue && StringUtils.isNotBlank(other)) {
            return dictService.getDictLabel(other, dictValue);
        }
        return null;
    }
}
