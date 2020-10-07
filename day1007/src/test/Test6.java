package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 新的日期时间类2
 * @author  杨卫兵
 * @version  [V1.00, 2020年10月7日]
 * @since V1.00
 */
public class Test6
{
    public static void main(String[] args)
    {
        LocalDateTime ldt1=LocalDateTime.of(2020,2,28,18,23,45);
        LocalDateTime ldt2=LocalDateTime.now();
        System.out.println(ldt1.isBefore(ldt2));
        LocalDateTime ldt3=ldt2.minus(1, ChronoUnit.MONTHS);
        System.out.println(ldt3);
        System.out.println("===========");
        long days=ldt1.until(ldt2, ChronoUnit.DAYS);
        System.out.println(days);
        System.out.println("===========");
        ldt1=LocalDateTime.of(2020,2,28,5,0,1);
        ldt2=LocalDateTime.of(2020,3,27,23,59,59);
        days=ldt1.until(ldt2, ChronoUnit.SECONDS);
        System.out.println(days);
        System.out.println("===========");
        LocalDate ld1=LocalDate.of(2020, 2, 1);
        LocalDate ld2=LocalDate.of(2010, 1, 5);
        Period pd= ld1.until(ld2);//时间范围
        System.out.println(pd);
        System.out.println("===========");
        LocalDateTime ldt4=ldt1.withHour(10);
        System.out.println(ldt4);
        
    }
}









