package test;

import com.xt.entity.Cat;
import com.xt.entity.Dog;
import com.xt.utils.SingletonObjectFactory2;

/**
 * 测试单例工厂（饿汉模式）
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月10日]
 * @since V1.00
 */
public class Test2
{
    public static void main(String[] args)
    {
        Cat cat=(Cat)SingletonObjectFactory2.getObject("cat");
        System.out.println("===========");
        Dog dog=(Dog)SingletonObjectFactory2.getObject("dog");
        System.out.println(dog);
        System.out.println("===========");
        Dog dog2=(Dog)SingletonObjectFactory2.getObject("dog");
        System.out.println(dog2);
    }
    
}
