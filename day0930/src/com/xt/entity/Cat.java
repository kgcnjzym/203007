package com.xt.entity;

public class Cat extends Pet
{
    private String name;
    
    public Cat(String name) {
        this.name=name;
    }
    
    public String getName() {
        return name;
    }
    
    public static void intro(Integer n) {
        for (int i = 0; i < n; i++)
        {
            System.out.println(i+1+".intro");
        }
    }
}
