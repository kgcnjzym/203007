package test;

import java.io.InputStream;
import java.util.Properties;

/**
 * Properties的使用:Map<String,String>
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年9月5日]
 * @since V1.00
 */
public class Test5
{
    public static void main(String[] args)
    {
        Properties props = new Properties();
        props.setProperty("abc", "hello");
        props.put("efg", "world");
        String value = props.getProperty("abc");
        System.out.println(value);
        value = (String)props.get("efg");
        System.out.println(value);
        System.out.println("=====加载properties文件的过程======");
        props = new Properties();
        InputStream is = null;
        try
        {
            is = Test5.class.getClassLoader().getResourceAsStream("config.properties");
            props.load(is);
            System.out.println(props);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                is.close();
            }
            catch (Exception e)
            {
            }
        }
//        props.load(
//            new FileInputStream("resources/config.properties")
//            );
    }
    
}
