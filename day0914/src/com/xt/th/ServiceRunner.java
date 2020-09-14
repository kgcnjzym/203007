package com.xt.th;

import org.apache.log4j.Logger;

import com.xt.service.UserService;

public class ServiceRunner implements Runnable
{
    private static Logger logger=Logger.getRootLogger();
    @Override
    public void run()
    {
        for(int i=0;i<3;i++) {
            UserService service=new UserService();
            logger.debug("service:"+service.hashCode());
            if(i==0) {
                service.reg();
            }
            else if(i==1) {
                service.login();
                DaoFactory.removeDao();
            }
            else {
                service.delete();
            }
        }
        
    }
    
}
