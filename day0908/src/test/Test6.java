package test;
/**
 * 通过反射创建对象实例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月8日]
 * @since V1.00
 */
public class Test6
{
    public static void main(String[] args)
    {
        Class<?> clz=null;
        try {
            clz=Class.forName("com.xt.entity.Student");
//            Object obj=clz.newInstance();
            //上述代码建议使用下列代码替代
//            Object obj=clz.getConstructor().newInstance();
            //有参构造方法的执行
            Object obj=clz.getConstructor(
                Integer.class,String.class).
                newInstance(20,"Mike");
            System.out.println(obj);
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        
    }
    
}
