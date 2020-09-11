package test;

import org.apache.log4j.Logger;

/**
 * 自定义线程类：继承Thread
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class MyThread extends Thread
{
    public MyThread(String name)
    {
        super(name);
    }
    public MyThread()
    {
        super("sub");
    }

    @Override
    public void run()
    {
        Logger logger=Logger.getRootLogger();
        for(int i=0;i<10;i++) {
            logger.debug("th i="+i);
        }
    }
    
}
