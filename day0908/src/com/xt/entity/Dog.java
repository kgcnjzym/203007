package com.xt.entity;

public class Dog extends Pet
{
    private String category;

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "Dog [category=" + category + ", getName()=" + getName() + ", getAge()=" + getAge() + "]";
    }
    
    
}
