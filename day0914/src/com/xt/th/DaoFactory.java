package com.xt.th;

import com.xt.dao.UserDao;

public class DaoFactory
{
    private static ThreadLocal<UserDao> local;
    //get set remove
    
    static {
        local=new ThreadLocal<UserDao>();
    }
    
    public static UserDao getDao() {
        UserDao dao=local.get();
        if(dao==null) {
            dao=new UserDao();
            local.set(dao);
        }
        return dao;
    }
    
    public static void removeDao() {        
        local.remove();
    }
}
