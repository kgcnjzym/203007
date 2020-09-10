package test;

import com.xt.entity.Cat;
import com.xt.entity.Dog;
import com.xt.utils.SingletonObjectFactory;

/**
 * 测试单例工厂（懒汉模式）
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月10日]
 * @since V1.00
 */
public class Test1
{
    public static void main(String[] args)
    {
        Cat cat=(Cat)SingletonObjectFactory.getObject("cat");
        System.out.println("===========");
        Dog dog=(Dog)SingletonObjectFactory.getObject("dog");
        System.out.println(dog);
        System.out.println("===========");
        Dog dog2=(Dog)SingletonObjectFactory.getObject("dog");
        System.out.println(dog2);
    }
    
}
