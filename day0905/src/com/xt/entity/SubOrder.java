package com.xt.entity;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class SubOrder extends Order
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5086483065955218131L;
    private String shipTo;
    
    public SubOrder() {}
    
    public SubOrder(int id,String name,Double money,Date date,String shipTo) {
        super(id,name,money,date);
        this.shipTo=shipTo;
    }
}
