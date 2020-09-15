package test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP通讯协议：Server端
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年9月15日]
 * @since V1.00
 */
public class TcpServer
{
    public static void main(String[] args)
    {
        ServerSocket server = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try
        {
            server = new ServerSocket(50001);
            System.out.println("创建ServerSocket");
            // 执行以下代码，在未得到连接请求时处于阻塞状态
            socket = server.accept();
            System.out.println("得到连接");
            is = socket.getInputStream();
            os = socket.getOutputStream();
            byte[] bts = new byte[4096];
            while (true)
            {
                // 执行以下代码，在未得到数据时处于阻塞状态
                int cnt = is.read(bts);
                String str = new String(bts, 0, cnt);
                System.out.println("服务器接收到：" + str);
                if("over".equalsIgnoreCase(str)) {
                    break;
                }
                os.write(("i got " + str).getBytes());
            }
            System.out.println("结束");
            
        }
        catch (Exception ex)
        {
            System.out.println(ex);
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
                server.close();
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
        
    }
    
}
