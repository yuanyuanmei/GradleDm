package com.example.account.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.account.beans.UserAccountBean;
import com.example.account.service.UserAccountService;
import com.example.common.constants.ApiFuncConsts;
import com.example.common.constants.ApiModuleConsts;
import com.example.common.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 用户controller
 */
@RestController
@RequestMapping(ApiModuleConsts.USER)
public class UserAccountController {

    @Autowired
    private UserAccountService accountService;

    //登录验证

    @PostMapping(ApiFuncConsts.LOGIN)
    public JSONObject login(UserAccountBean paramBean) {
        //1.帐号密码登录
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(paramBean.getAccount(),paramBean.getPassword(),"");
        try {
            //执行认证操作.
            subject.login(token);
            //设置过期时间
            subject.getSession().setTimeout(2*60*60*1000);
            return StringUtils.formatSuccessJson("登录成功");
        }catch (UnknownAccountException ua){
            return StringUtils.formatFailJson("帐号不存在");
        }catch (AuthenticationException ae) {
            return StringUtils.formatFailJson("帐号密码错误");
        }

    }

    //注册验证
    @ResponseBody
    @PostMapping(ApiFuncConsts.REIGISTER)
    public JSONObject register(UserAccountBean paramBean) {
        return accountService.save(paramBean);
    }

    //登出
    @GetMapping(ApiFuncConsts.LOGOUT)
    public JSONObject logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return null;
    }

}
