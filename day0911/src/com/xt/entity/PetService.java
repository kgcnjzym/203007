package com.xt.entity;

import org.apache.log4j.Logger;

public class PetService
{
    private static Logger logger=Logger.getRootLogger();
    public synchronized void modifyAge(Pet pet) {
        int age=pet.getAge();
        age++;
        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {}
        pet.setAge(age);
        logger.debug("modifyAge in PetService:修改完成。");
    }
}
