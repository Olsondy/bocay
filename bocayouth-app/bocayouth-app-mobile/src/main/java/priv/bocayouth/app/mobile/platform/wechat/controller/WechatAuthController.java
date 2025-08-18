package priv.bocayouth.app.mobile.platform.wechat.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.stp.parameter.SaLoginParameter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import priv.bocayouth.app.mobile.platform.wechat.domain.vo.WechatLoginVo;
import priv.bocayouth.common.core.domain.R;
import priv.bocayouth.common.core.domain.model.WechatLoginBody;

/**
 * @author Olsond
 * @date 2025/8/11 23:24
 * @description
 */
@SaIgnore
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class WechatAuthController {
    /**
     * 微信小程序登录
     */
    @PostMapping("/wx-login")
    public R<WechatLoginVo> wxLogin(@Validated  @RequestBody WechatLoginBody loginBody) {
        String code = loginBody.getLoginCode();
        // todo 查询系统客户端配置信息
//        SysClientVo client = clientService.queryByClientId(clientId);
//        // 查询不到 client 或 client 内不包含 grantType
//        if (ObjectUtil.isNull(client) || !StringUtils.contains(client.getGrantType(), grantType)) {
//            log.info("客户端id: {} 认证类型：{} 异常!.", clientId, grantType);
//            return R.fail(I18nUtils.message("auth.grant.type.error"));
//        } else if (!SystemConstants.NORMAL.equals(client.getStatus())) {
//            return R.fail(I18nUtils.message("auth.grant.type.blocked"));
//        }
//        loginUser.setClientKey(client.getClientKey());
//        loginUser.setDeviceType(client.getDeviceType());
        SaLoginParameter model = new SaLoginParameter();
//        model.setDeviceType(client.getDeviceType());
        // 自定义分配 不同用户体系 不同 token 授权时间 不设置默认走全局 yml 配置
        // 例如: 后台用户30分钟过期 app用户1天过期
//        model.setTimeout(client.getTimeout());
//        model.setActiveTimeout(client.getActiveTimeout());
//        model.setExtra(LoginHelper.CLIENT_KEY, client.getClientId());
        // 生成token
//        LoginHelper.login(loginUser, model);
        // todo 保存用户sessionKey openid
//        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
//                "appid=" + wechatProperties.getAppId() +
//                "&secret=" + wechatProperties.getAppSecret() +
//                "&js_code=" + code +
//                "&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(url, WxSession.class);
        WechatLoginVo loginVo = new WechatLoginVo();
        loginVo.setAccessToken(StpUtil.getTokenValue());
        loginVo.setExpireIn(StpUtil.getTokenTimeout());
        return R.ok(loginVo);
    }
}
