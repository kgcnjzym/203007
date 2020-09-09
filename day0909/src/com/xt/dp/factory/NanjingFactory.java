package com.xt.dp.factory;

import com.xt.dp.entity.Cole;
import com.xt.dp.entity.Cookie;
import com.xt.dp.entity.Drink;
import com.xt.dp.entity.SaltCookie;
/**
 * 具体工厂：南京
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月9日]
 * @since V1.00
 */
public class NanjingFactory extends AbstractFactory
{
    @Override
    public Drink productDrink()
    {
        return new Cole();
    }

    @Override
    public Cookie productCookie()
    {
        return new SaltCookie();
    }
    
}
