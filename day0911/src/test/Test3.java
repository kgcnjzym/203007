package test;

import org.apache.log4j.Logger;

/**
 * 多线程示例3
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class Test3
{
    public static void main(String[] args)
    {
        Logger logger=Logger.getRootLogger();
        Thread []ths=new Thread[4];
        for (int i = 0; i < ths.length; i++)
        {
            ths[i]=new Thread(new SecondThread(),"th"+i);
            if(i==1) {
                ths[i].setPriority(10);
            }
            ths[i].start();
        }
        
        for (int i = 0; i < 10; i++)
        {
            logger.debug("i="+i);
        }
    }
}
