package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * UDP聊天室Server端
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月16日]
 * @since V1.00
 */
public class UdpChatRoomServer
{
    public static void main(String[] args)
    {
        DatagramSocket socket = null;
        DatagramPacket packet = null;
        byte[] bts = new byte[4096];
        try
        {
            socket = new DatagramSocket(52000);
            packet = new DatagramPacket(bts, bts.length);
            while (true)
            {
                System.out.println("等待数据...");
                // 执行下列代码后，等待数据，处于阻塞状态
                socket.receive(packet);
                String str = new String(bts, 0, packet.getLength());
                System.out.println("接收到["+packet.getSocketAddress()+"]的信息：" + str);
                if(str.startsWith("login,")) {
                    doLogin(str.substring(6),packet.getAddress());
                }
                else if(str.startsWith("logoff,")) {
                    doLogoff(str.substring(7));
                }
                else if(str.startsWith("send,")) {
                    doSend(str.substring(5));
                }
                else if(str.startsWith("sendTo,")) {
                    doSendTo(str.substring(7));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("ex:" + e);
        }
        finally
        {
            socket.close();
        }
    }

    private static void doSendTo(String msg)
    {
        // tom,mike,message
        String []arr=msg.split(",",3);
        ChatUser user=users.get(arr[0]);
        if(user==null) {
            return;
        }
        ChatUser target=users.get(arr[1]);
        if(target==null) {
            return;
        }
        Thread th=new UdpSendThread("【"+arr[0]+"】对【"+arr[1]+"】说："+arr[2], target);
        th.start();
    }

    private static void doSend(String msg)
    {
        //tom,123,456
        String []arr=msg.split(",",2);
        ChatUser user=users.get(arr[0]);
        if(user==null) {
            return;
        }
        for(ChatUser target:users.values()) {
            if(target.getName().equals(arr[0])) {
                continue;
            }
            Thread th=new UdpSendThread("【"+arr[0]+"】说："+arr[1], target);
            th.start();
        }
    }

    private static void doLogoff(String msg)
    {
        ChatUser user=users.get(msg);
        if(user==null) {
            return;
        }
        users.remove(msg);
        Thread th=new UdpSendThread("logoffok,", user);
        th.start();
    }

    private static Map<String ,ChatUser> users=new HashMap<>();
    private static void doLogin(String msg,InetAddress address)
    {
        //tom,50001
        String ip=address.toString();
        if(ip.startsWith("/")) {
            ip=ip.substring(1);
        }
        String[] arr=msg.split(",");
        ChatUser user=new ChatUser();
        user.setIp(ip);
        user.setName(arr[0]);
        user.setPort(Integer.valueOf(arr[1]));
        String message="";
        if(users.containsKey(arr[0])) {
            message="fail,username exists";
        }
        else {
            users.put(arr[0], user);
            message="ok,";
        }
        Thread th=new UdpSendThread(message, user);
        th.start();
        
    }
}
