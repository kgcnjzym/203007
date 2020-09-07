package test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * 反射综合示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月7日]
 * @since V1.00
 */
public class Test3
{
    public static void main(String[] args) throws Exception
    {
        Properties props=new Properties();
        InputStream is=Test3.class.getClassLoader().getResourceAsStream("dog.txt");
        props.load(is);
        is.close();
        
        Class<?> clz=Class.forName(props.getProperty("class"));
        Object obj=clz.newInstance();
        System.out.println("创建对象类型："+obj.getClass());
        Field mas=clz.getField("master");
        System.out.println("新建后："+mas.get(obj));
        mas.set(obj, props.getProperty("master"));
        System.out.println("赋值后："+mas.get(obj));
        
    }
    
}
