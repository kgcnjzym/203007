package test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * 套接字I/O处理线程
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月15日]
 * @since V1.00
 */
public class SocketThread extends Thread
{
    private Socket socket;
    private static Logger logger=Logger.getRootLogger();
    public SocketThread(Socket socket) {
        super(""+socket.getRemoteSocketAddress());
        this.socket=socket;
    }
    @Override
    public void run()
    {
        try(InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();){
            byte[] bts = new byte[4096];
            while (true)
            {
                int cnt = is.read(bts);
                String str = new String(bts, 0, cnt);
                logger.debug("服务器接收到：" + str);
                if("over".equalsIgnoreCase(str)) {
                    break;
                }
                os.write(("i got " + str).getBytes());
            }
            logger.debug("结束");
        }
        catch(Exception ex) {
            logger.warn(ex);
        }
    }
    
    
}
