package test;

import com.xt.entity.Cat;
import com.xt.entity.Dog;
import com.xt.utils.InstanceObjectFactory;

/**
 * 测试实例工厂
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月10日]
 * @since V1.00
 */
public class Test3
{
    public static void main(String[] args)
    {
        Cat cat=(Cat)InstanceObjectFactory.getObject("cat");
        System.out.println("===========");
        Dog dog=(Dog)InstanceObjectFactory.getObject("dog");
        System.out.println(dog);
        System.out.println("===========");
        Dog dog2=(Dog)InstanceObjectFactory.getObject("dog");
        System.out.println(dog2);
    }
    
}
