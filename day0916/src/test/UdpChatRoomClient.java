package test;

import java.util.Scanner;

import com.xt.utils.InputUtil;

/**
 * UDP聊天室Client端
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年9月16日]
 * @since V1.00
 */
public class UdpChatRoomClient
{
    public static boolean logined = false;
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        InputUtil.scanner = scanner;
        String name = null;
        int port = 0;
        ChatUser server = new ChatUser();
        server.setIp("10.0.0.72");
        server.setPort(52000);
        while (true)
        {
            System.out.println("请选择：");
            System.out.println("1.login");
            System.out.println("2.send");
            System.out.println("3.send to");
            System.out.println("4.logoff");
            int choice = InputUtil.acceptInt(1, 4);
            Thread th ;
            Thread thRece;
            switch (choice)
            {
                case 1:
                    System.out.println("请输入用户名:");
                    name = InputUtil.acceptString();
                    System.out.println("请输入端口");
                    port = InputUtil.acceptInt(5001, 65535);
                    thRece=new UdpReceThread(port);
                    thRece.start();
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (Exception e)
                    {}
                    th = new UdpSendThread("login," + name + "," + port, server);
                    th.start();
                    break;
                case 2:
                    if (logined)
                    {
                        System.out.println("请输入信息:");
                        String message = InputUtil.acceptString();
                         th = new UdpSendThread("send," + name + "," + message, server);
                        th.start();
                    }
                    else
                    {
                        System.out.println("请先登陆");
                    }
                    break;
                case 3:
                    if (logined)
                    {
                        System.out.println("请输入收信人:");
                        String target = InputUtil.acceptString();
                        System.out.println("请输入信息:");
                        String message = InputUtil.acceptString();
                         th = new UdpSendThread("sendTo," + name + "," +target+"," + message, server);
                        th.start();
                    }
                    else
                    {
                        System.out.println("请先登陆");
                    }
                    break;
                
                default:
                    if (logined)
                    {
                        logined=false;
                        th = new UdpSendThread("logoff," + name , server);
                        th.start();
                    }
                    else
                    {
                        System.out.println("尚未登陆");
                    }
            }
            if (choice == 4)
            {
                break;
            }
        }
        scanner.close();
        
    }
    
}
