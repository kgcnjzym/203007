package test;

import java.lang.reflect.Field;

import com.xt.entity.Dog;

/**
 * Field测试
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月7日]
 * @since V1.00
 */
public class Test2
{
    public static void main(String[] args) throws Exception
    {
        Class<?> clz=Dog.class;
        Field []fds=clz.getFields();
        for (int i = 0;fds!=null && i < fds.length; i++)
        {
            System.out.println(fds[i].getName());
        }
        System.out.println("==========");
        fds=clz.getDeclaredFields();
        for (int i = 0;fds!=null && i < fds.length; i++)
        {
            System.out.println(fds[i].getName());
        }
        System.out.println("==========");
        Dog dog=new Dog();
        System.out.println(dog.master);
        Field fldMaster=clz.getField("master");
        fldMaster.set(dog, "tom");
        System.out.println(dog.master);
        Field fldHeight=clz.getDeclaredField("height");
        fldHeight.setAccessible(true);//不建议使用，破坏封装特性
        fldHeight.set(dog, 100);
        System.out.println(fldHeight.get(dog));
    }
    
}
