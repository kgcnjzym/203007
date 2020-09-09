package com.xt.dp.factory;

import com.xt.dp.entity.Drink;

/**
 * 简单工厂
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月9日]
 * @since V1.00
 */
public class DrinkFactory
{
    /**
     * 定义生产线：
     *  根据参数进行反射，再创建对象
     * @param type      具体产品的类型全名FQDN
     * @return
     */
    public static Drink product(String type) {
        Drink drink=null;
        try {
            Class<?> clz=Class.forName(type);
            drink=(Drink)clz.newInstance();
        }
        catch(Exception ex) {
            System.out.println("ex:"+ex);
        }
        return drink;
    }
}
