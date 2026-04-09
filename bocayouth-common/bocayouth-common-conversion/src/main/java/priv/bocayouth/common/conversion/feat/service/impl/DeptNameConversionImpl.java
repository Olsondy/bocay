package priv.bocayouth.common.conversion.feat.service.impl;

import lombok.AllArgsConstructor;
import priv.bocayouth.common.conversion.annotation.ConversionType;
import priv.bocayouth.common.conversion.constant.ConversionConstant;
import priv.bocayouth.common.conversion.feat.service.ConversionInterface;
import priv.bocayouth.common.core.feat.service.DeptService;

/**
 * 部门转换实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@ConversionType(type = ConversionConstant.DEPT_ID_TO_NAME)
public class DeptNameConversionImpl implements ConversionInterface<String> {

    private final DeptService deptService;

    @Override
    public String conversion(Object key, String other) {
        if (key instanceof String ids) {
            return deptService.selectDeptNameByIds(ids);
        } else if (key instanceof Long id) {
            return deptService.selectDeptNameByIds(id.toString());
        }
        return null;
    }
}
