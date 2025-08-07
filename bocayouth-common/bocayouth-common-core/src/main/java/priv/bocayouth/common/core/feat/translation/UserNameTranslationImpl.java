package priv.bocayouth.common.core.feat.translation;

import lombok.AllArgsConstructor;
import priv.bocayouth.common.core.annotation.translation.TranslationType;
import priv.bocayouth.common.core.constant.TransConstant;
import priv.bocayouth.common.core.feat.core.UserService;

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
