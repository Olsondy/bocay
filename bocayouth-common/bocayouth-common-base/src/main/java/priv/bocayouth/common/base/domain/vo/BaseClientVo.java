package priv.bocayouth.common.base.domain.vo;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import priv.bocayouth.common.base.domain.SysClient;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


/**
 * 授权管理视图对象 sys_client
 *
 * @author Michelle.Chung
 * @date 2023-05-15
 */
@Data
@AutoMapper(target = SysClient.class)
public class BaseClientVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * idempotent
     */
    private Long id;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 客户端key
     */
    private String clientKey;

    /**
     * 客户端秘钥
     */
    private String clientSecret;

    /**
     * 授权类型
     */
    private List<String> grantTypeList;

    /**
     * 授权类型
     */
    private String grantType;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * token活跃超时时间
     */
    private Long activeTimeout;

    /**
     * token固定超时时间
     */
    private Long timeout;

    /**
     * 状态（0停用 1正常）
     */
    private String status;


}
