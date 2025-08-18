package priv.bocayouth.app.mobile.platform.wechat.service;

import priv.bocayouth.app.mobile.platform.wechat.domain.vo.WechatLoginVo;
import priv.bocayouth.common.core.domain.model.WechatLoginBody;

/**
 * @author Olsond
 * @date 2025/8/12 19:37
 * @description
 */
public interface IWechatService {
    /**
     *  微信登录
     * @param loginBody
     * @return WechatLoginVo
     */
    WechatLoginVo wechatLogin(WechatLoginBody loginBody);
}
