package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议发送端
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月16日]
 * @since V1.00
 */
public class UdpSend
{
    public static void main(String[] args)
    {
        DatagramSocket socket=null;
        DatagramPacket packet=null;
        InetAddress address=null;
        try
        {
            address=InetAddress.getByName("10.0.0.72");
            byte[]bts="hello udp".getBytes();
            socket=new DatagramSocket();
            packet=new DatagramPacket(
                bts, bts.length, address,52000);
            socket.send(packet);
            System.out.println("send ok");
        }
        catch (Exception e)
        {
            System.out.println("ex:"+e);
        }
        finally {
            socket.close();
        }
    }
    
}
