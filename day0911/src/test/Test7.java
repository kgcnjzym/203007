package test;

import org.apache.log4j.Logger;

import com.xt.entity.Pet;

/**
 * 线程同步问题:给代码块加锁
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class Test7
{
    public static void main(String[] args)
    {
        Pet pet=new Pet(10);
        Logger logger=Logger.getRootLogger();
        logger.debug("pet.age="+pet.getAge());//10
        Thread th1=new Thread(new ModifyAgeThread(pet),"th1");
        Thread th2=new Thread(new ModifyAgeThread(pet),"th2");
        th1.start();
        th2.start();
        
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {}
        logger.debug("pet.age="+pet.getAge());
        
    }
    
}
