package test;

import com.xt.dp.entity.Drink;
import com.xt.dp.factory.DrinkFactory;

/**
 * 简单工厂示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月9日]
 * @since V1.00
 */
public class Test2
{
    public static void main(String[] args)
    {
        Drink drink=DrinkFactory.product("com.xt.dp.entity.Fonta");
        System.out.println(drink);
        
    }
    
}
