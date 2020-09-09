package com.xt.entity;
/**
 * 单例实体类
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月9日]
 * @since V1.00
 */
public class Singleton
{
    //2.定义一个私有静态变量:
    //饿汉（eager）模式：预先创建，不管何时需要
//    private static Singleton object=new Singleton();
    //懒汉（lazy）模式：需要时才创建
    private static Singleton object=null;
    //1.构造方法私有化
    private Singleton() {}
    
    //3.定义一个静态公有方法，用于获取私有静态变量
    public static Singleton getInstance() {
        //懒汉（lazy）模式
        if(object==null) {
            object=new Singleton();
        }
        return object;
    }
}
