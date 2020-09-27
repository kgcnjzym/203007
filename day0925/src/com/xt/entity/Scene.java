package com.xt.entity;

import lombok.Data;

@Data
public class Scene implements Cloneable
{
    private String type;
    private String desc;
    private String unit;
    private Integer number;
    
    @Override
    public String toString() {
        return String.format(desc, number,unit);
    }

    @Override
    public Object clone()
        throws CloneNotSupportedException
    {
        // TODO Auto-generated method stub
        return super.clone();
    }
}
