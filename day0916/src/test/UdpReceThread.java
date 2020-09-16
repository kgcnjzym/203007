package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceThread extends Thread
{
    private DatagramSocket socket;
    
    private DatagramPacket packet;
    
    private int  port;
    
    public UdpReceThread(int port) {
        this.port=port;
    }
    
    @Override
    public void run()
    {
        try
        {
            byte[] bts = new  byte[4096];
            socket = new DatagramSocket(port);
            packet = new DatagramPacket(bts, bts.length);
            while(true) {
                socket.receive(packet);
                String str=new String(bts,0,packet.getLength());
                if(str.startsWith("ok,")) {
                    UdpChatRoomClient.logined=true;
                    System.out.println("登陆成功！");
                }
                else if(str.startsWith("logoffok,")) {
                    break;
                }
                System.out.println(str);
            }
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
