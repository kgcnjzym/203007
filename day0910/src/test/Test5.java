package test;

import java.lang.reflect.Proxy;

import com.xt.dao.BookDao;
import com.xt.dao.impl.BookDaoImpl;
import com.xt.proxy.LoggerInvocationHandler;

/**
 * 测试动态代理 
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月10日]
 * @since V1.00
 */
public class Test5
{
    public static void main(String[] args)
    {
//        UserDao dao=new UserDaoImpl();
//        UserDao proxy=(UserDao)Proxy.newProxyInstance(
//            Test5.class.getClassLoader(), 
//            dao.getClass().getInterfaces(),
//            new LoggerInvocationHandler(dao));
//        proxy.reg("admin", "mike@qqq.com", "11111");
//        proxy.login("admin", "123456");
        
        BookDao dao=new BookDaoImpl();
        BookDao proxy=(BookDao)Proxy.newProxyInstance(
          Test5.class.getClassLoader(), 
          dao.getClass().getInterfaces(),
          new LoggerInvocationHandler(dao));
        proxy.add("  ", "dd", 11);
        proxy.delete("122");
        System.out.println("end of main");
        
        
    }
    
}
