package com.xt.dp;

/**
 * 线程安全的单例（懒汉）
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年9月14日]
 * @since V1.00
 */
public class Singleton
{
    private static Singleton instance;
    
    private Singleton()
    {
        
    }
    
    public static Singleton getInstance()
    {
        if (instance == null)
        {
            try
            {
                Thread.sleep(400);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            synchronized (Singleton.class)
            {
                if(instance==null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
        
    }
}
