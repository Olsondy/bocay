package priv.bocayouth.common.tenant.handler;

import cn.hutool.core.collection.ListUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.StringValue;
import priv.bocayouth.common.core.utils.StringUtils;
import priv.bocayouth.common.tenant.config.properties.TenantProperties;
import priv.bocayouth.common.tenant.feat.helper.TenantHelper;

import java.util.List;

/**
 * 自定义租户处理器
 *
 * @author Lion Li
 */
@Slf4j
@AllArgsConstructor
public class TenantLineHandler implements com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler {

    private final TenantProperties tenantProperties;

    @Override
    public Expression getTenantId() {
        String tenantId = TenantHelper.getTenantId();
        if (StringUtils.isBlank(tenantId)) {
            log.error("无法获取有效的租户id -> Null");
            return new NullValue();
        }
        // 返回固定租户
        return new StringValue(tenantId);
    }

    @Override
    public boolean ignoreTable(String tableName) {
        String tenantId = TenantHelper.getTenantId();
        // 判断是否有租户
        if (StringUtils.isNotBlank(tenantId)) {
            // 不需要过滤租户的表
            List<String> excludes = tenantProperties.getExcludes();
            // 非业务表
            List<String> tables = ListUtil.toList(
                "sys_gen_table",
                "sys_gen_table_column"
            );
            tables.addAll(excludes);
            return StringUtils.equalsAnyIgnoreCase(tableName, tables.toArray(new String[0]));
        }
        return true;
    }

}
