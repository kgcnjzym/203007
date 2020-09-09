package com.xt.dp.factory;

import com.xt.dp.entity.Cookie;
import com.xt.dp.entity.Drink;

/**
 * 抽象工厂
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月9日]
 * @since V1.00
 */
public abstract class AbstractFactory
{
    /**
     * 创建工厂
     * @param type  具体工厂类型全名
     * @return
     */
    public static AbstractFactory newFactory(String type) {
        AbstractFactory factory=null;
        try {
            Class<?> clz=Class.forName(type);
            factory=(AbstractFactory)clz.newInstance();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        return factory;
    }
    /**
     * 定义生成的产品规范
     * @return
     */
    public abstract Drink productDrink() ;
    
    
    public abstract Cookie productCookie();
}
