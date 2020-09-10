package com.xt.dao;
/**
 * 用户的数据访问层接口
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月10日]
 * @since V1.00
 */
public interface UserDao
{
    int login(String name,String pass);
    
    int reg(String name,String email,String pass);
}
