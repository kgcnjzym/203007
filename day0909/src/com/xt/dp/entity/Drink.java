package com.xt.dp.entity;
/**
 * 抽象产品：饮料
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月9日]
 * @since V1.00
 */
public abstract class Drink
{
    private String brand;
    private String pack;
    private Double price;
    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    public String getPack()
    {
        return pack;
    }
    public void setPack(String pack)
    {
        this.pack = pack;
    }
    public Double getPrice()
    {
        return price;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }
}
