package priv.bocayouth.app.mobile.platform.wechat.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import priv.bocayouth.app.mobile.platform.wechat.domain.vo.WechatLoginVo;
import priv.bocayouth.app.mobile.platform.wechat.service.IWechatService;
import priv.bocayouth.common.core.domain.model.WechatLoginBody;
import priv.bocayouth.common.mobile.config.properties.WechatProperties;

/**
 * @author Olsond
 * @date 2025/8/12 19:37
 * @description
 */
@Log4j2
@RequiredArgsConstructor
@Service
public class WechatServiceImpl implements IWechatService {

    private WechatProperties wechatProperties;

    @Override
    public WechatLoginVo wechatLogin(WechatLoginBody loginBody) {
        return null;
    }
}
