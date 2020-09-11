package test;

import org.apache.log4j.Logger;

/**
 * 多线程示例2
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class Test2
{
    public static void main(String[] args)
    {
        Logger logger=Logger.getRootLogger();
        //创建Runnable实现类对象
        Runnable ra=new SecondThread();
        //再创建线程对象,传入Runnable实现类对象
        Thread th=new Thread(ra,"Sub");
        //启动线程
        th.start();
        for (int i = 0; i < 10; i++)
        {
            logger.debug("i="+i);
        }
    }
}
