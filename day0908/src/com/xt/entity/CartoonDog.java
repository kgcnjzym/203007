package com.xt.entity;

import com.xt.anno.FirstAnno;

@FirstAnno
public class CartoonDog extends Dog
{
    private String company;

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }
    
    protected void test() {
        System.out.println("test in CartoonDog");
    }
    public void test(int a) {
        System.out.println("test(int) in CartoonDog,a="+a);
    }
    
    @FirstAnno("static method")
    public static void func() {
        System.out.println("func in CartoonDog");
    }
}
