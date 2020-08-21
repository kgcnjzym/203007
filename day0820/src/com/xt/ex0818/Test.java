package com.xt.ex0818;

public class Test
{
    
    public static void main(String[] args)
    {
        Ink ink=new MonoInk();
        Paper paper=new B5Paper();
        Printer pt=new Printer(ink,paper);
        pt.print();
        
    }
    
}
