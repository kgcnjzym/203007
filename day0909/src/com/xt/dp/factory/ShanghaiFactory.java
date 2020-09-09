package com.xt.dp.factory;

import com.xt.dp.entity.Cookie;
import com.xt.dp.entity.Drink;
import com.xt.dp.entity.Spirit;
import com.xt.dp.entity.SweetCookie;
/**
 * 具体工厂：上海
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月9日]
 * @since V1.00
 */
public class ShanghaiFactory extends AbstractFactory
{
    @Override
    public Drink productDrink()
    {
        return new Spirit();
    }

    @Override
    public Cookie productCookie()
    {
        return new SweetCookie();
    }
    
}
