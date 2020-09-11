package test;

import org.apache.log4j.Logger;

/**
 * 多线程示例4
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class Test4
{
    public static void main(String[] args)
    {
        Logger logger=Logger.getRootLogger();
        Thread []ths=new Thread[5];
        for (int i = 0; i < ths.length; i++)
        {
            if(i==0) {
                ths[i]=new Thread(new DaemonThread(),"deamon");
//                ths[i].setDaemon(true);
            }
            else{
                ths[i]=new Thread(new SecondThread(),"th"+i);
            }
            ths[i].start();
        }
        
        for (int i = 0; i < 10; i++)
        {
            logger.debug("i="+i);
        }
    }
}
