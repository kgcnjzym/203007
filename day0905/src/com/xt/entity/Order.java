package com.xt.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于测试序列化的实体类
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月5日]
 * @since V1.00
 */
@Data
public class Order implements Serializable
{
    {
        System.out.println("Order init...");
    }
    public Order() {
        System.out.println("default constructor");
    }
    
    public Order(int id,String name,Double money,Date date) {
        this.id=id;
        this.name=name;
        this.money=money;
        this.date=date;
        System.out.println("constructor with parameter");
    }
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private Double money;
    private Date date;
}
