package priv.bocayouth.generator.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import priv.bocayouth.common.core.feat.mybaits.BaseMapperPlus;
import priv.bocayouth.generator.domain.GenTableColumn;

/**
 * 业务字段 数据层
 *
 * @author Lion Li
 */
@InterceptorIgnore(dataPermission = "true", tenantLine = "true")
public interface GenTableColumnMapper extends BaseMapperPlus<GenTableColumn, GenTableColumn> {

}
