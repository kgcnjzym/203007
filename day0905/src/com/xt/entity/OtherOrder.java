package com.xt.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class OtherOrder extends Order
{
    private User contact;
    
    public OtherOrder(int id,String name,Double money,Date date,User contact) {
        super(id,name,money,date);
        this.contact=contact;
    }
}
