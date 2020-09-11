package test;

import org.apache.log4j.Logger;

/**
 * 自定义精灵线程类：实现Runnable接口
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class DaemonThread implements Runnable
{
    @Override
    public void run()
    {
        Logger logger=Logger.getRootLogger();
        while(true) {
            logger.debug("this is daemon thread");
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {}
        }
        
    }
    
}
