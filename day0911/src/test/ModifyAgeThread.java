package test;

import org.apache.log4j.Logger;

import com.xt.entity.Pet;

public class ModifyAgeThread implements Runnable
{
    private Pet pet;
    private static Logger logger=Logger.getRootLogger();
    
    public ModifyAgeThread(Pet pet) {
        this.pet=pet;
    }
    @Override
    public void run()
    {
        //这里必须保证在任何一个线程中，
        //括号中的对象都是同一个对象
        //否则同步锁无任何意义
        synchronized(pet) {
            int age=pet.getAge();
            age++;
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {}
            pet.setAge(age);
            logger.debug("修改完成。");
        }
    }
    
}
