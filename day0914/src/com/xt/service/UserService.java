package com.xt.service;

import com.xt.dao.UserDao;
import com.xt.th.DaoFactory;

/**
 * 模拟Service
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月14日]
 * @since V1.00
 */
public class UserService
{
    private UserDao dao;
    public UserService() {
        dao=DaoFactory.getDao();
    }
    
    public void reg() {
        dao.add();
    }
    
    public void delete() {
        dao.delete();
    }
    public void login() {
        dao.get();
    }
}
