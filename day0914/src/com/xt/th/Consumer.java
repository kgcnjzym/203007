package com.xt.th;

import java.util.Random;

import org.apache.log4j.Logger;

/**
 * 消费者
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月14日]
 * @since V1.00
 */
public class Consumer implements Runnable
{
    private static Logger logger=Logger.getRootLogger();
    private Stock stock;
    public Consumer(Stock stock) {
        this.stock=stock;
    }
    @Override
    public void run()
    {
        Random random=new Random();
        while (true)
        {
            synchronized(stock) {
                while(stock.isEmpty()) {
                    logger.debug("等待");
                    try
                    {
                        stock.wait();
                    }
                    catch (InterruptedException e)
                    {}
                }
                String str=stock.sell();
                logger.debug("购买："+str);
                stock.notifyAll();
            }
            try
            {
                int n=random.nextInt(1000)+100;
                Thread.sleep(n);
                logger.debug("休息了"+n+"毫秒");
            }
            catch (InterruptedException e)
            {}
        }
        
    }
    
}
