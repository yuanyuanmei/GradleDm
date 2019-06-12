package com.example.account.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.account.beans.SysPermissionBean;
import com.example.account.beans.SysRoleBean;
import com.example.account.beans.UserBaseBean;
import com.example.account.service.SysPermissionService;
import com.example.account.service.SysRoleService;
import com.example.account.service.UserBaseService;
import com.example.common.constants.ApiFuncConsts;
import com.example.common.constants.ApiModuleConsts;
import com.example.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 权限列表管理
 */
@Controller
@RequestMapping(ApiModuleConsts.SYS)
public class SysController {

    @Autowired
    private UserBaseService baseService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysPermissionService permsService;

    //用户修改或新增
    @ResponseBody
    @PostMapping(ApiFuncConsts.USER)
    public JSONObject saveUser(UserBaseBean paramBean){
        return StringUtils.formatSuccessJson("更新成功");
    }

    //用户修改或新增
    @ResponseBody
    @PostMapping(ApiFuncConsts.ROLE)
    public JSONObject saveRole(SysRoleBean paramBean){
        return StringUtils.formatSuccessJson("更新成功");
    }

    //用户修改或新增
    @ResponseBody
    @PostMapping(ApiFuncConsts.MENU)
    public JSONObject saveMenu(SysPermissionBean paramBean){
        return StringUtils.formatSuccessJson("更新成功");
    }
}
