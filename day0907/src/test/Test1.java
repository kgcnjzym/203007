package test;


/**
 * 通过类型名称获取Class
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月7日]
 * @since V1.00
 */
public class Test1
{
    public static void main(String[] args) throws Exception
    {
//        Class c1=Student.class;
        // 方式1：类型名称.class
        // 方式2：对象.getClass()
        // 方式3：通过类型全限定名称(FQDN)
        Class<?> clz=Class.forName("com.xt.entity.Student");
//        Class clz=int.class;
//        int[]arr= {};
//        Class clz=arr.getClass();
        System.out.println(clz);
        System.out.println(clz.isInterface());//false
        System.out.println(clz.isPrimitive());//false
        System.out.println(clz.isArray());//false
        System.out.println(clz.getSuperclass().getName());//java.lang.Object
        System.out.println(clz.getSuperclass().getSimpleName());//Object
        
        
    }
    
}
