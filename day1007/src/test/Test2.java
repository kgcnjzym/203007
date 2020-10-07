package test;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 流式编程示例2
 * @author  杨卫兵
 * @version  [V1.00, 2020年10月7日]
 * @since V1.00
 */
public class Test2
{
    public static void main(String[] args)
    {
        Random rnd=new Random();
        IntStream is=rnd.ints(10,0,100);
        //数据收集:存为List
        List<Integer> lst=is.collect(ArrayList::new, 
            ArrayList::add, ArrayList::addAll);
        System.out.println(lst);
        //使用有初始值的降解方法
        Integer sum=lst.stream().reduce(1000,
            (a,b)->a.intValue()+b.intValue());
        System.out.println(sum);
        //使用无初始值的降解方法
        sum=lst.stream().reduce(
            (a,b)->a+b).get();
        System.out.println(sum);
        System.out.println("=============");
        lst.stream().forEach(System.out::println);
        System.out.println("=============");
        //获取统计对象
        IntSummaryStatistics statistics = 
            lst.stream().mapToInt(n->n.intValue()).summaryStatistics();
        System.out.println(statistics.getSum());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
    }
}






