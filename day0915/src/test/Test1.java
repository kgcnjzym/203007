package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

/**
 * InetAddress、URL测试
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月15日]
 * @since V1.00
 */
public class Test1
{
    public static void main(String[] args) throws Exception
    {
        InetAddress addr=InetAddress.getLocalHost();
        System.out.println(addr);
        addr=InetAddress.getByName("baidu.com");
        System.out.println(addr);
        System.out.println("=============");
        //URL:uniform resource locator < URI: u r identifier
        //协议://用户认证@主机:端口/路径/资源?查询字符串#锚点
        URL url=new URL("http://xtaccp.com/");
        URLConnection conn = url.openConnection();
        InputStream is=conn.getInputStream();
        InputStreamReader isr=new InputStreamReader(is,"UTF-8");
        BufferedReader br=new BufferedReader(isr);
        String str=null;
        int cnt=1;
        while((str=br.readLine())!=null) {
            System.out.println(cnt+" "+str);
            cnt++;
        }
    }
    
}
