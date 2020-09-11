package test;

import org.apache.log4j.Logger;

/**
 * 多线程示例6
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class Test6
{
    public static void main(String[] args)
    {
        Logger logger=Logger.getRootLogger();
        Thread th1=new Thread(new ThirdThread(0),"th0");
        Thread th2=new Thread(new ThirdThread(1),"th1");
        th1.start();
        th2.start();
        logger.debug("end of main");
    }
}
