package test;

import com.xt.th.Consumer;
import com.xt.th.Producer;
import com.xt.th.Stock;

/**
 * 生产者-消费者测试
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月14日]
 * @since V1.00
 */
public class Test3
{
    public static void main(String[] args)
    {
        Stock stock=new Stock();
        Producer p1=new Producer(stock);
//        Producer p2=new Producer(stock);
        Consumer c1=new Consumer(stock);        
        Consumer c2=new Consumer(stock);        
        Thread th1=new Thread(p1,"生产A");
//        Thread th2=new Thread(p2,"生产B");
        Thread th2=new Thread(c2,"消费乙");
        Thread th3=new Thread(c1,"消费甲");
        
        th1.start();
        th2.start();
        th3.start();
    }
    
}
