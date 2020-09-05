package test;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 使用DataOutputStream输出数据
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月5日]
 * @since V1.00
 */
public class Test1
{
    public static void main(String[] args)
    {
        OutputStream os=null;
        DataOutputStream dos=null;
        try {
            os=new FileOutputStream("data");
            dos=new DataOutputStream(os);
            dos.writeInt(65535);//00 00 ff ff
            dos.writeBoolean(false);//00
            dos.writeUTF("ABCDEF");//00 06 41 42  ..
            dos.writeByte(64);//40
            System.out.println("ok");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        finally {
            try
            {
                dos.close();
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
