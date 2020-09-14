package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.xt.th.MyRunner;

/**
 * 0911课后练习测试
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月14日]
 * @since V1.00
 */
public class Test1
{
    public static void main(String[] args)
    {
        Thread th1=new Thread(new MyRunner(1));
        Thread th2=new Thread(new MyRunner(2));
        Thread th3=new Thread(new MyRunner(3));
        List<Thread> ths=new ArrayList<>();
        ths.add(th1);
        ths.add(th2);
        ths.add(th3);
        ths.sort(new Comparator<Thread>()
        {
            @Override
            public int compare(Thread o1, Thread o2)
            {
                Random rnd=new Random();
                return rnd.nextInt(10)-5;
            }
        });
        for (int i = 0; i < ths.size(); i++)
        {
            ths.get(i).start();
            try
            {
                ths.get(i).join();
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
