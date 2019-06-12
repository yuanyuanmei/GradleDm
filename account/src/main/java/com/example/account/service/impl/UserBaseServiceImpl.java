package com.example.account.service.impl;

import com.example.account.beans.UserBaseBean;
import com.example.account.dao.UserBaseDao;
import com.example.account.service.UserBaseService;
import com.example.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户基础业务实现类
 */
@Service
public class UserBaseServiceImpl extends BaseServiceImpl<UserBaseBean> implements UserBaseService {

    @Autowired
    private UserBaseDao baseDao;

}
