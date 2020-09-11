package test;

import org.apache.log4j.Logger;

/**
 * 自定义线程类：实现Runnable接口
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class ThirdThread implements Runnable
{
    private int id;
    public ThirdThread(int id) {
        this.id=id;
    }
    @Override
    public void run()
    {
        Logger logger=Logger.getRootLogger();
        for(int i=0;i<100;i++) {
            if(id==0 && i%10==0) {
                Thread.yield();
            }
            logger.debug("th i="+i);
        }
        logger.debug(" ending...");
        
    }
    
}
