package test;

import org.apache.log4j.Logger;

/**
 * log4j的简单示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月10日]
 * @since V1.00
 */
public class Test6
{
    public static void main(String[] args)
    {
        Logger log=Logger.getRootLogger();
        log.debug("this is debug message");
        log.info("this is info message");
        log.warn("this is warn message");
        log.error("this is error message");
        log.fatal("this is fatal message");
        
        
        
    }
    
}
