package test;

import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 流式编程示例1
 * @author  杨卫兵
 * @version  [V1.00, 2020年10月7日]
 * @since V1.00
 */
public class Test1
{
    public static void main(String[] args)
    {
        Random rnd=new Random();
        IntStream is=rnd.ints(20,0,100);
//        is.forEach(n->System.out.println(n));
//        is.forEach(System.out::println);
        //牛肉，玉米，土豆
        is.filter(n->n%2==0)  //荤菜
            .map(n->n*10)       //烧
            .forEach(System.out::println);
        System.out.println("============");
        //降解reduce求和
        is=rnd.ints(20,0,100);
        int sum=is.reduce((a,b)->a+b).getAsInt();
        System.out.println(sum);
        System.out.println("============");
        //降解reduce求极值
        is=rnd.ints(20,0,100);
        int max=is.reduce((a,b)->a>b?a:b).getAsInt();
        System.out.println(max);
        System.out.println("============");
        //通过统计类进行计算
        is=rnd.ints(20,0,100);
        IntSummaryStatistics statistics = is.summaryStatistics();
        System.out.println("sum="+statistics.getSum());
        System.out.println("avg="+statistics.getAverage());
        System.out.println("max="+statistics.getMax());
        System.out.println("min="+statistics.getMin());
        
        
        
    }
}






