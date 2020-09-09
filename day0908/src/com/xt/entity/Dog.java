package com.xt.entity;

public class Dog extends Pet
{
    private String category;
    private Boolean checked=false;

    public String getCategory()
    {
        return category;
    }
    
    public String getDemo() {
        return "demo";
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

    public Boolean isChecked()
    {
        return checked;
    }

    public void setChecked(Boolean checked)
    {
        this.checked = checked;
    }
    
    
}
