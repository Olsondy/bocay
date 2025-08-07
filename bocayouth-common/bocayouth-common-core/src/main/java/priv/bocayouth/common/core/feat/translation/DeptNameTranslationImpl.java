package priv.bocayouth.common.core.feat.translation;

import lombok.AllArgsConstructor;
import priv.bocayouth.common.core.annotation.translation.TranslationType;
import priv.bocayouth.common.core.constant.TransConstant;
import priv.bocayouth.common.core.feat.core.DeptService;

/**
 * 部门翻译实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@TranslationType(type = TransConstant.DEPT_ID_TO_NAME)
public class DeptNameTranslationImpl implements TranslationInterface<String> {

    private final DeptService deptService;

    @Override
    public String translation(Object key, String other) {
        if (key instanceof String ids) {
            return deptService.selectDeptNameByIds(ids);
        } else if (key instanceof Long id) {
            return deptService.selectDeptNameByIds(id.toString());
        }
        return null;
    }
}
