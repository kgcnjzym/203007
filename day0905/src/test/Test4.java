package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import com.xt.entity.Order;

/**
 * 使用ObjectInputStream序列化数据
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月5日]
 * @since V1.00
 */
public class Test4
{
    public static void main(String[] args)
    {
        InputStream is=null;
        ObjectInputStream ois=null;
        try {
            is=new FileInputStream("object");
            ois=new ObjectInputStream(is);            
            Order order=(Order)ois.readObject();
            System.out.println("ok:"+order);
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        finally {
            try
            {
                ois.close();
            }
            catch (IOException e) {}
            try
            {
                is.close();
            }
            catch (IOException e) {}
        }
        
        
    }
    
}
