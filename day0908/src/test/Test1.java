package test;

import java.lang.reflect.Field;

import com.xt.entity.CartoonDog;
/**
 * 0907课后练习2
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月8日]
 * @since V1.00
 */
public class Test1
{
    public static void main(String[] args)
    {
        Field ret=getField(CartoonDog.class,"name");
        System.out.println(ret);
    }
    public static Field getField(Class<?> clz,String fieldName){
        if(clz==null || clz==Object.class) {
            return null;
        }
        try {
            return clz.getDeclaredField(fieldName);
        }
        catch(Exception ex) {
            return getField(clz.getSuperclass(),fieldName);
        }
    }
}
