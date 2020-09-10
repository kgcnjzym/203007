package com.xt.dao.impl;

import com.xt.dao.UserDao;

public class UserDaoImpl implements UserDao
{
    
    @Override
    public int login(String name, String pass)
    {
        if("admin".equals(name) && "123456".equals(pass)) {
            return 1;
        }
        return 0;
    }
    
    @Override
    public int reg(String name, String email, String pass)
    {
        if(!"admin".equals(name) && ! "admin@qq.com".equals(email)) {
            return 1;
        }
        return 0;
    }
    
}
