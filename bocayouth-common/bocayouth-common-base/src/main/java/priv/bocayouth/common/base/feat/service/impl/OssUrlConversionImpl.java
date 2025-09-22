package priv.bocayouth.common.base.feat.service.impl;

import lombok.AllArgsConstructor;
import priv.bocayouth.common.base.annotation.ConversionType;
import priv.bocayouth.common.base.constant.ConversionConstant;
import priv.bocayouth.common.base.feat.service.ConversionInterface;
import priv.bocayouth.common.core.feat.service.OssService;

/**
 * OSS翻译实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@ConversionType(type = ConversionConstant.OSS_ID_TO_URL)
public class OssUrlConversionImpl implements ConversionInterface<String> {

    private final OssService ossService;

    @Override
    public String conversion(Object key, String other) {
        if (key instanceof String ids) {
            return ossService.selectUrlByIds(ids);
        } else if (key instanceof Long id) {
            return ossService.selectUrlByIds(id.toString());
        }
        return null;
    }
}
