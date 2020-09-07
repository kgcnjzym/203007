package com.xt.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Enumeration;

/**
 * 自定义注解类型
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月7日]
 * @since V1.00
 */
@Target({ElementType.TYPE,ElementType.METHOD,
    ElementType.FIELD,ElementType.PARAMETER,
    ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstAnno
{
    int[] value() default {1,2,3};
//    int test();//setter
//    int a=10;
//    String name() default "test";
    
}
