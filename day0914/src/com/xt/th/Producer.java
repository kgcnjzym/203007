package com.xt.th;

import java.util.Random;

import org.apache.log4j.Logger;

/**
 * 生产者
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年9月14日]
 * @since V1.00
 */
public class Producer implements Runnable
{
    private static Logger logger = Logger.getRootLogger();
    private static int i = 0;
    private Stock stock;
    
    public Producer(Stock stock)
    {
        this.stock = stock;
    }
    
    @Override
    public void run()
    {
        Random random = new Random();
        
        while (true)
        {
            synchronized (stock)
            {
                while (stock.isFull())
                {
                    try
                    {
                        stock.wait();
                    }
                    catch (InterruptedException e)
                    {
                    }
                }
                String str = "商品" + (++i);
                stock.store(str);
                logger.debug("生产：" + str);
                stock.notifyAll();
                
            }
            try
            {
                int n = random.nextInt(1000) + 500;
                Thread.sleep(n);
                logger.debug("休息了" + n + "毫秒");
            }
            catch (InterruptedException e)
            {
            }
        }
    }
    
}
