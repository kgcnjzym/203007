package test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 新的日期时间类3
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年10月7日]
 * @since V1.00
 */
public class Test7
{
    public static void main(String[] args)
    {
        // 新转旧
        LocalDateTime ldt1 = LocalDateTime.of(2020, 2, 28, 18, 23, 45);
        Instant ins = ldt1.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(ins);
        System.out.println(date);
        
        //旧转新
        Date now=new Date();
        Instant ins2=now.toInstant();
        LocalDateTime ldt2=ins2.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(ldt2);
        
    }
}
