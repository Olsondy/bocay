package priv.bocayouth.common.core.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Olsond
 * @date 2025/8/12 03:19
 * @description 微信登录主体
 */
@Data

public class WechatLoginBody implements Serializable {
    /**
     * 微信 login code
     */
    private String loginCode;

    /**
     * 小程序appid
     */
    private String appid;

    /**
     * 授权类型 (微信或手机号)
     */
    private String grantType;
}
