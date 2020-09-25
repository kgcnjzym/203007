package com.xt.entity;

import lombok.Data;

@Data
public class Scene
{
    private String type;
    private String desc;
    private String unit;
    private Integer number;
    
    @Override
    public String toString() {
        return String.format(desc, number,unit);
    }
}
