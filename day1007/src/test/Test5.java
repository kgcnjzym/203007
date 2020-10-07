package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 新的日期时间类1
 * @author  杨卫兵
 * @version  [V1.00, 2020年10月7日]
 * @since V1.00
 */
public class Test5
{
    public static void main(String[] args)
    {
//        Date date=new Date();
        LocalDate now=LocalDate.now();
        System.out.println(now);
        LocalTime tm=LocalTime.now();
        System.out.println(tm);
        LocalDateTime dt=LocalDateTime.now();
        System.out.println(dt);
//        Date date=new Date(2020,10,8);
        LocalDate ld1=LocalDate.of(2020, 10, 8);
        System.out.println(ld1);
        LocalTime lt1=LocalTime.of(11,12,34);
        System.out.println(lt1);
        LocalDateTime ldt1=LocalDateTime.of(2010,2,28,18,23,45);
        System.out.println(ldt1);
        System.out.println("========");
        DateTimeFormatter fmt=DateTimeFormatter.ofPattern(
            "yyyy年MM月dd日HH时mm分ss秒");
        String str=ldt1.format(fmt);
        System.out.println(str);
//        str=fmt.format(ldt1);
//        System.out.println(str);
//        LocalDateTime ldt2=LocalDateTime.parse(
//            "2020年02月30日18时23分45秒", fmt);
        LocalDateTime ldt2=LocalDateTime.from(
            fmt.parse("2020年12月29日23时59分59秒"));
        System.out.println(ldt2);
        
    }
}









