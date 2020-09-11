package test;

import org.apache.log4j.Logger;

/**
 * 多线程示例1
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月11日]
 * @since V1.00
 */
public class Test1
{
    public static void main(String[] args)
    {
        Logger logger=Logger.getRootLogger();
        //创建线程对象
        Thread th=new MyThread("Test");
        //启动线程
        th.start();
        //直接调用run并不会产生子线程
//        th.run();
        for (int i = 0; i < 10; i++)
        {
            logger.debug("i="+i);
        }
    }
}
