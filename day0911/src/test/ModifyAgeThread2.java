package test;

import org.apache.log4j.Logger;

import com.xt.entity.Pet;
import com.xt.entity.PetService;

public class ModifyAgeThread2 implements Runnable
{
    private Pet pet;
    private PetService petService;
    private static Logger logger=Logger.getRootLogger();
    
    public ModifyAgeThread2(Pet pet,PetService service) {
        this.pet=pet;
        this.petService=service;
    }
    @Override
    public void run()
    {
        petService.modifyAge(pet);
        logger.debug("run in ModifyAgeThread2 ending.");
    }
    
}
