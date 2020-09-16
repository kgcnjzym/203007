package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP协议接收端
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年9月16日]
 * @since V1.00
 */
public class UdpRece
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
                System.out.println("接收到["+packet.getAddress()+"]的信息：" + str);
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
    
}
