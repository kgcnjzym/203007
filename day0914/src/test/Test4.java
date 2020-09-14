package test;

import com.xt.th.DaoFactory;
import com.xt.th.ServiceRunner;

/**
 * ThreadLocal示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月14日]
 * @since V1.00
 */
public class Test4
{
    
    public static void main(String[] args)
    {
        Thread th1=new Thread(new ServiceRunner(),"service1");
        Thread th2=new Thread(new ServiceRunner(),"service2");
        th1.start();
        th2.start();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("===========");
        th1=new Thread(new ServiceRunner(),"service1");
        th1.start();
       
        
    }
    
}
