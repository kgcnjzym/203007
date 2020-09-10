package com.xt.proxy;

import com.xt.dao.UserDao;
/**
 * UserDao的静态代理类
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月10日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class UserDaoProxy implements UserDao
{
    private UserDao dao;
    public UserDaoProxy(UserDao dao) {
        this.dao=dao;
    }
    @Override
    public int login(String name, String pass)
    {
        //代理目标方法执行前记录参数
        LoggerRecord.log("login("+name+","+pass+")");
        int ret=dao.login(name, pass);
        //代理目标方法执行后记录返回结果
        LoggerRecord.log("return value="+ret);
        return ret;
    }
    
    @Override
    public int reg(String name, String email, String pass)
    {
        LoggerRecord.log("reg("+name+","+email+","+pass+")");
        int ret=dao.reg(name, email, pass);
        LoggerRecord.log("return value="+ret);
        return ret;
    }
    
}
