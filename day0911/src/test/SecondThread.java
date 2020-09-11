package test;

import org.apache.log4j.Logger;

/**
 * 自定义线程类：实现Runnable接口
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class SecondThread implements Runnable
{
    
    @Override
    public void run()
    {
        Logger logger=Logger.getRootLogger();
        for(int i=0;i<10;i++) {
//            if(i==5) {
//                try
//                {
//                    Thread.sleep(10000);
//                }
//                catch (InterruptedException e)
//                {
//                    
//                }
//            }
            logger.debug("th i="+i);
        }
        logger.debug(" ending...");
        
    }
    
}
