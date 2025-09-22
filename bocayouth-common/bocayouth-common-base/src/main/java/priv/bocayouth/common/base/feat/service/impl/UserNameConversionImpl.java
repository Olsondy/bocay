package priv.bocayouth.common.base.feat.service.impl;

import lombok.AllArgsConstructor;
import priv.bocayouth.common.base.annotation.ConversionType;
import priv.bocayouth.common.base.constant.ConversionConstant;
import priv.bocayouth.common.base.feat.service.ConversionInterface;
import priv.bocayouth.common.core.feat.service.UserService;

/**
 * 用户名转换实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@ConversionType(type = ConversionConstant.USER_ID_TO_NAME)
public class UserNameConversionImpl implements ConversionInterface<String> {

    private final UserService userService;

    @Override
    public String conversion(Object key, String other) {
        if (key instanceof Long id) {
            return userService.selectUserNameById(id);
        }
        return null;
    }
}
