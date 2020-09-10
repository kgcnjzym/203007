package test;

import com.xt.dao.UserDao;
import com.xt.dao.impl.UserDaoImpl;
import com.xt.proxy.UserDaoProxy;

/**
 * 测试静态代理 
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月10日]
 * @since V1.00
 */
public class Test4
{
    public static void main(String[] args)
    {
        UserDao dao=new UserDaoImpl();
        UserDao proxy=new UserDaoProxy(dao);
        proxy.reg("admin", "mike@qqq.com", "11111");
        proxy.login("admin", "123456");
        System.out.println("end of main");
        
        
    }
    
}
