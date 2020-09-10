package com.xt.proxy;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * 日志记录器
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月10日]
 * @since V1.00
 */
public class LoggerRecord
{
    public static void log(String message) {
        OutputStream os=null;
        Writer writer=null;
        BufferedWriter bw=null;
        try {
            os=new FileOutputStream("test.log",true);
            writer=new OutputStreamWriter(os,"UTF-8");
            bw=new BufferedWriter(writer);
            bw.write(message);
            bw.newLine();
        }
        catch(Exception ex) {
            
        }
        finally {
            try
            {
                bw.close();
            }
            catch (Exception e)
            {}
            try
            {
                writer.close();
            }
            catch (Exception e)
            {}
            try
            {
                os.close();
            }
            catch (Exception e)
            {}
        }
    }
}
