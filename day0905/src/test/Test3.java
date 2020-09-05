package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.xt.entity.Order;
import com.xt.entity.SubOrder;

/**
 * 使用ObjectOutputStream序列化数据
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月5日]
 * @since V1.00
 */
public class Test3
{
    public static void main(String[] args)
    {
        Order order=new Order(1,"mike",null,new Date());
//        Order order=new SubOrder(1,"mike",200.45,new Date(),"nanjing");
//        Order order=new OtherOrder(1,"mike",200.45,new Date(),new User("mike","111111111"));
        OutputStream os=null;
        ObjectOutputStream oos=null;
        try {
            os=new FileOutputStream("object");
            oos=new ObjectOutputStream(os);  
            oos.writeObject(order);
            System.out.println("ok");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        finally {
            try
            {
                oos.close();
            }
            catch (IOException e) {}
            try
            {
                os.close();
            }
            catch (IOException e) {}
        }
        
        
    }
    
}
