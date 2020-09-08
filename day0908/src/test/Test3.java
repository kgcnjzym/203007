package test;

import java.lang.reflect.Method;

import com.xt.entity.CartoonDog;

/**
 * Method示例2
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月8日]
 * @since V1.00
 */
public class Test3
{
    public static void main(String[] args)
    {
        Class<?> clz=CartoonDog.class;
        Object obj=null;
        Method mth=null;
        try {
            obj=clz.newInstance();
            mth=clz.getMethod("test",int.class);
            //obj.method();
            mth.invoke(obj,5);
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        System.out.println("====静态方法====");
        try {
            mth=clz.getMethod("func");
            mth.invoke(null);
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
}
