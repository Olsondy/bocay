package priv.bocayouth.common.conversion.feat.service.impl;

import lombok.AllArgsConstructor;
import priv.bocayouth.common.conversion.annotation.ConversionType;
import priv.bocayouth.common.conversion.constant.ConversionConstant;
import priv.bocayouth.common.conversion.feat.service.ConversionInterface;
import priv.bocayouth.common.core.feat.service.UserService;

/**
 * 用户名称转换实现
 *
 * @author may
 */
@AllArgsConstructor
@ConversionType(type = ConversionConstant.USER_ID_TO_NICKNAME)
public class NicknameConversionImpl implements ConversionInterface<String> {

    private final UserService userService;

    @Override
    public String conversion(Object key, String other) {
        if (key instanceof Long id) {
            return userService.selectNicknameByIds(id.toString());
        } else if (key instanceof String ids) {
            return userService.selectNicknameByIds(ids);
        }
        return null;
    }
}
