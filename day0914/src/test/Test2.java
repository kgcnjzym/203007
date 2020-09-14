package test;

import org.apache.log4j.Logger;

import com.xt.dp.Singleton;

/**
 * 多线程下的单例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月14日]
 * @since V1.00
 */
public class Test2
{
    public static void main(String[] args)
    {
        Logger logger=Logger.getRootLogger();
        Thread th1=new Thread() {
          @Override
          public void run() {
              Singleton t1=Singleton.getInstance();
              logger.debug("t1:"+t1.hashCode());
          }
        };
        Thread th2=new Thread() {
            @Override
            public void run() {
                Singleton t1=Singleton.getInstance();
                logger.debug("t1:"+t1.hashCode());
            }
          };
          
        th1.start();
        th2.start();
        
    }
    
}
