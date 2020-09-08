package test;

import java.lang.reflect.Method;

import com.xt.entity.CartoonDog;

/**
 * Method示例1
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月8日]
 * @since V1.00
 */
public class Test2
{
    public static void main(String[] args)
    {
        Class<?> clz=CartoonDog.class;
        Method []mths=clz.getMethods();
        for (int i = 0; i < mths.length; i++)
        {
            System.out.println(mths[i].getName());
        }
        System.out.println("==========");
        mths=clz.getDeclaredMethods();
        for (int i = 0; i < mths.length; i++)
        {
            System.out.println(mths[i].getName());
        }
    }
    
}
