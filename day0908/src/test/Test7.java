package test;

import com.xt.utils.ObjectUtil;

/**
 * 对象工具类测试
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月8日]
 * @since V1.00
 */
public class Test7
{
    public static void main(String[] args)
    {
        Object obj=ObjectUtil.createObject("target.properties");
        if(obj==null) {
            System.out.println("创建失败");
        }
        else {
            System.out.println(obj);
        }
        
    }
    
}
