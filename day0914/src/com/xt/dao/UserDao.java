package com.xt.dao;

import org.apache.log4j.Logger;

/**
 * 模拟DAO层
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月14日]
 * @since V1.00
 */
public class UserDao
{
    private static Logger logger=Logger.getRootLogger();
    
    public void add() {
        logger.debug(this.hashCode()+"添加用户");
    }
    
    public void delete() {
        logger.debug(this.hashCode()+"删除用户");
    }
    
    public void get() {
        logger.debug(this.hashCode()+"获取用户");
    }
}
