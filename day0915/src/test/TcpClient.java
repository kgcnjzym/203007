package test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP通讯协议：Client端
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年9月15日]
 * @since V1.00
 */
public class TcpClient
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try
        {
            socket = new Socket("localhost", 50001);
            System.out.println("连接成功！");
            is = socket.getInputStream();
            os = socket.getOutputStream();
            byte[] bts = new byte[4096];
            
            while (true)
            {
                System.out.println("请输入：");
                String in = scanner.next();
                os.write(in.getBytes());
                if("over".equalsIgnoreCase(in)) {
                    break;
                }
                int cnt = is.read(bts);
                System.out.println("客户端收到：" + new String(bts, 0, cnt));
            }
            System.out.println("结束");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch (Exception e)
            {
            }
            try
            {
                is.close();
            }
            catch (Exception e)
            {
            }
            try
            {
                os.close();
            }
            catch (Exception e)
            {
            }
        }
        scanner.close();
        
    }
    
}
