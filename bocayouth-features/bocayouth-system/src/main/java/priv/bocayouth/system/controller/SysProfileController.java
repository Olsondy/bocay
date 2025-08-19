package priv.bocayouth.system.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.BCrypt;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import priv.bocayouth.common.core.annotation.Log;
import priv.bocayouth.common.core.annotation.encrypt.ApiEncrypt;
import priv.bocayouth.common.core.domain.R;
import priv.bocayouth.common.core.enums.BusinessType;
import priv.bocayouth.common.core.helper.DataPermissionHelper;
import priv.bocayouth.common.core.helper.LoginHelper;
import priv.bocayouth.common.core.utils.StringUtils;
import priv.bocayouth.common.core.feat.controller.BaseController;
import priv.bocayouth.system.domain.bo.SysUserBo;
import priv.bocayouth.system.domain.bo.SysUserPasswordBo;
import priv.bocayouth.system.domain.bo.SysUserProfileBo;
import priv.bocayouth.system.domain.vo.SysUserVo;
import priv.bocayouth.system.service.ISysUserService;

/**
 * 个人信息 业务处理
 *
 * @author Lion Li
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/user/profile")
public class SysProfileController extends BaseController {

    private final ISysUserService userService;

    /**
     * 个人信息
     */
    @GetMapping
    public R<ProfileVo> profile() {
        SysUserVo user = userService.selectUserById(LoginHelper.getUserId());
        String roleGroup = userService.selectUserRoleGroup(user.getUserId());
        String postGroup = userService.selectUserPostGroup(user.getUserId());
        ProfileVo profileVo = new ProfileVo(user, roleGroup, postGroup);
        return R.ok(profileVo);
    }

    /**
     * 修改用户信息
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> updateProfile(@Validated @RequestBody SysUserProfileBo profile) {
        SysUserBo user = BeanUtil.toBean(profile, SysUserBo.class);
        user.setUserId(LoginHelper.getUserId());
        String username = LoginHelper.getUsername();
        if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user)) {
            return R.fail("修改用户'" + username + "'失败，手机号码已存在");
        }
        if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user)) {
            return R.fail("修改用户'" + username + "'失败，邮箱账号已存在");
        }
        int rows = DataPermissionHelper.ignore(() -> userService.updateUserProfile(user));
        if (rows > 0) {
            return R.ok();
        }
        return R.fail("修改个人信息异常，请联系管理员");
    }

    /**
     * 重置密码
     *
     * @param bo 新旧密码
     */
    @ApiEncrypt
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PutMapping("/updatePwd")
    public R<Void> updatePwd(@Validated @RequestBody SysUserPasswordBo bo) {
        SysUserVo user = userService.selectUserById(LoginHelper.getUserId());
        String password = user.getPassword();
        if (!BCrypt.checkpw(bo.getOldPassword(), password)) {
            return R.fail("修改密码失败，旧密码错误");
        }
        if (BCrypt.checkpw(bo.getNewPassword(), password)) {
            return R.fail("新密码不能与旧密码相同");
        }
        int rows = DataPermissionHelper.ignore(() -> userService.resetUserPwd(user.getUserId(), BCrypt.hashpw(bo.getNewPassword())));
        if (rows > 0) {
            return R.ok();
        }
        return R.fail("修改密码异常，请联系管理员");
    }

    public record AvatarVo(String imgUrl) {}

    public record ProfileVo(SysUserVo user, String roleGroup, String postGroup) {}

}
