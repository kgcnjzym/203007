package com.xt.entity;

import com.xt.anno.FirstAnno;

@FirstAnno({4,5,6})
public class Student
{
    @FirstAnno
    private String name;

    @FirstAnno
    public String getName()
    {
        return name;
    }

    public void setName(@FirstAnno String name)
    {
        @FirstAnno
        String temp=name.toUpperCase();
        this.name = temp;
    }
}
