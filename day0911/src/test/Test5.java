package test;

import org.apache.log4j.Logger;

/**
 * 多线程示例5
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class Test5
{
    public static void main(String[] args)
    {
        Logger logger=Logger.getRootLogger();
        Thread []ths=new Thread[4];
        for (int i = 0; i < ths.length; i++)
        {
            ths[i]=new Thread(new SecondThread(),"th"+i);
            ths[i].start();
            try
            {
                if(i==3) {
                    ths[i].join();
                }
            }
            catch (InterruptedException e)
            {}
        }
        
        
        for (int i = 0; i < 10; i++)
        {
            logger.debug("i="+i);
        }
    }
}
