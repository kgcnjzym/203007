package test;

import java.util.HashMap;
import java.util.Map;

import com.xt.utils.ObjectUtil;

/**
 * 对象工具类测试2
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月8日]
 * @since V1.00
 */
public class Test8
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
        
        Map<String,Object> map=new HashMap<>();
        map.put("category","拉布拉多");
        map.put("age",5);
        map.put("name","mmmm");
        map.put("checked",true);
        ObjectUtil.setProperties(obj, map);
        System.out.println(obj);
        System.out.println("===========");
        try {
            System.out.println(ObjectUtil.getPropertyValue(obj, "demo"));
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
