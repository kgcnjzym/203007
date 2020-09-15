package test;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP通讯协议：支持多客户端连接的Server端
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年9月15日]
 * @since V1.00
 */
public class MultiTcpServer
{
    public static void main(String[] args)
    {
        ServerSocket server = null;
        Socket socket = null;
        
        try
        {
            server = new ServerSocket(50001);
            System.out.println("创建ServerSocket");
            while(true) {
                socket = server.accept();
                System.out.println("得到连接");
                Thread th=new SocketThread(socket);
                th.start();
            }
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
            
        }
        
    }
    
}
