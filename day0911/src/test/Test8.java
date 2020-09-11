package test;

import org.apache.log4j.Logger;

import com.xt.entity.Pet;
import com.xt.entity.PetService;

/**
 * 线程同步问题2：给方法加锁
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class Test8
{
    public static void main(String[] args)
    {
        Pet pet=new Pet(10);
        PetService service=new PetService();
        Logger logger=Logger.getRootLogger();
        logger.debug("pet.age="+pet.getAge());//10
        Thread th1=new Thread(new ModifyAgeThread2(pet,service),"th1");
        Thread th2=new Thread(new ModifyAgeThread2(pet,service),"th2");
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
