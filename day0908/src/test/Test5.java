package test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.xt.anno.FirstAnno;
import com.xt.entity.CartoonDog;

/**
 * Annotation示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月8日]
 * @since V1.00
 */
public class Test5
{
    public static void main(String[] args)
    {
        Class<?> clz=CartoonDog.class;
        Method mth=null;
        
        try {
            mth=clz.getMethod("func");
            Annotation []annos=clz.getAnnotations();
            for (int i = 0; i < annos.length; i++)
            {
                System.out.println(annos[i]);
            }
            annos=mth.getAnnotations();
            for (int i = 0; i < annos.length; i++)
            {
                System.out.println(annos[i]);
            }
            FirstAnno anno=clz.getAnnotation(FirstAnno.class);
            System.out.println(anno.value());
            
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
}
