package test;

import com.xt.entity.Singleton;

/**
 * 单例示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月9日]
 * @since V1.00
 */
public class Test1
{
    public static void main(String[] args) throws Exception
    {
        Singleton t1=Singleton.getInstance();
        Singleton t2=Singleton.getInstance();
        System.out.println(t1);
        System.out.println(t2);
        
    }
    
}
