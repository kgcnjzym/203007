package test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 使用DataInputStream输出数据
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月5日]
 * @since V1.00
 */
public class Test2
{
    public static void main(String[] args)
    {
        InputStream is=null;
        DataInputStream dis=null;
        try {
            is=new FileInputStream("data");
            dis=new DataInputStream(is);
            
            boolean b=dis.readBoolean();
            System.out.println(b);
            int a=dis.readInt();
            System.out.println(a);
            String str=dis.readUTF();
            System.out.println(str);
            a=dis.readByte();
            System.out.println(a);
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        finally {
            try
            {
                dis.close();
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
