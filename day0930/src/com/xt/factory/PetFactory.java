package com.xt.factory;

import java.util.function.Function;
import java.util.function.Supplier;

import com.xt.entity.Pet;
public class PetFactory
{
    /**
     * 函数声明接口Supplier
     * @param <T>
     * @param sup
     * @return
     */
    public static <T extends Pet> T 
        createPet(Supplier<T> sup) {
        return sup.get();
    }
    
    /**
     * 函数声明接口Function
     * @param <T>
     * @param sup
     * @return
     */
    public static <T extends Pet> T 
        createPet(Function<String,T> func,String name) {
        return func.apply(name);
    }
}
