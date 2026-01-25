package priv.bocayouth.common.core.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 移动端登录权限
 * @author Olsond
 * @date 2026/1/24
 */
@Data
public class MobileLoginUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 客户id
     */
    private Long partyId;
    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 全局id
     */
    private String globalId;
    /**
     * 用户身份标识
     */
    private String identityValue;

    /**
     * 用户身份标识类型
     */
    private String identityType;

    /**
     * 微信的sessionKey
     */
    private String sessionKey;

    /**
     * 平台类型
     */
    private String platform;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 设备类型
     */
    private String deviceType;


}