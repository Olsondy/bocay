package priv.bocayouth.common.web.feat.service.impl;

import lombok.AllArgsConstructor;
import priv.bocayouth.common.web.annotation.TranslationType;
import priv.bocayouth.common.web.constant.TransConstant;
import priv.bocayouth.common.core.feat.core.UserService;
import priv.bocayouth.common.web.feat.service.TranslationInterface;

/**
 * 用户名翻译实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@TranslationType(type = TransConstant.USER_ID_TO_NAME)
public class UserNameTranslationImpl implements TranslationInterface<String> {

    private final UserService userService;

    @Override
    public String translation(Object key, String other) {
        if (key instanceof Long id) {
            return userService.selectUserNameById(id);
        }
        return null;
    }
}
