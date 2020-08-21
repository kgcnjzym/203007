package com.xt.ex0818;

public class Printer
{
    private Ink ink;
    private Paper paper;
    public Ink getInk()
    {
        return ink;
    }
    public void setInk(Ink ink)
    {
        this.ink = ink;
    }
    public Paper getPaper()
    {
        return paper;
    }
    public void setPaper(Paper paper)
    {
        this.paper = paper;
    }
    public Printer(Ink ink, Paper paper)
    {
        this.ink = ink;
        this.paper = paper;
    }
    public Printer()
    {
    }
    
    public void print() {
        System.out.println("打印机使用"+ink+"在"+paper+"上打印。");
    }
}
