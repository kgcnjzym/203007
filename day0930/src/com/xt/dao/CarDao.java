package com.xt.dao;
/**
 * 接口中添加静态方法示例
 * 接口中的静态方法一定是默认方法，有方法体
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月30日]
 * @since V1.00
 */
public interface CarDao
{
    static void test() {
        System.out.println("this is static method");
    }
    
    
}
