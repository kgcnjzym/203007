package test;

import com.xt.dp.entity.Cookie;
import com.xt.dp.entity.Drink;
import com.xt.dp.factory.AbstractFactory;

/**
 * 抽象工厂示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月9日]
 * @since V1.00
 */
public class Test3
{
    public static void main(String[] args)
    {
        AbstractFactory factory=AbstractFactory.newFactory(
            "com.xt.dp.factory.NanjingFactory");
        Drink drink=factory.productDrink();
        System.out.println(drink);
        Cookie cookie=factory.productCookie();
        System.out.println(cookie);
        
    }
    
}
