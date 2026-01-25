package priv.bocayouth.common.core.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    @NotBlank(message = "login code is not blank")
    private String loginCode;

    @NotNull
    @NotBlank(message = "phone code is not blank")
    private String phoneCode;
    /**
     * 小程序appid
     */
    private String clientId;

    /**
     * 授权类型 (微信或手机号)
     */
    private String grantType;
}
