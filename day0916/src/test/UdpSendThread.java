package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSendThread extends Thread
{
    private DatagramSocket socket;
    
    private DatagramPacket packet;
    
    private String message;    
    private ChatUser user;
    
    public UdpSendThread(String message,ChatUser user) {
        this.message=message;
        this.user=user;
    }
    
    @Override
    public void run()
    {
        InetSocketAddress address;
        try
        {
            address=new InetSocketAddress(user.getIp() , user.getPort());
            byte[] bts = message.getBytes();
            socket = new DatagramSocket();
            packet = new DatagramPacket(bts, bts.length, address);
            socket.send(packet);
        }
        catch (Exception ex)
        {
            
        }
        finally
        {
            socket.close();
        }
    }
    
}
