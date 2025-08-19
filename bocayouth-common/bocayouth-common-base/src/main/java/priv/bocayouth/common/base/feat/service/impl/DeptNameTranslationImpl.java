package priv.bocayouth.common.base.feat.service.impl;

import lombok.AllArgsConstructor;
import priv.bocayouth.common.base.annotation.ConversionType;
import priv.bocayouth.common.base.constant.ConversionConstant;
import priv.bocayouth.common.base.feat.service.ConversionInterface;
import priv.bocayouth.common.base.feat.service.DeptService;

/**
 * 部门转换实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@ConversionType(type = ConversionConstant.DEPT_ID_TO_NAME)
public class DeptNameTranslationImpl implements ConversionInterface<String> {

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
