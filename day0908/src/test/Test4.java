package test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import com.xt.entity.CartoonDog;

/**
 * Modifier示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月8日]
 * @since V1.00
 */
public class Test4
{
    public static void main(String[] args)
    {
        Class<?> clz=CartoonDog.class;
        Method mth=null;
        
        try {
            mth=clz.getMethod("func");
            int modi=mth.getModifiers();
            System.out.println(Modifier.isPublic(modi));
            System.out.println(Modifier.isStatic(modi));
            System.out.println(
                Modifier.isInterface(List.class.getModifiers()));
            System.out.println(modi);//9
            System.out.println((modi&Modifier.PRIVATE) == Modifier.PRIVATE);
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
}
