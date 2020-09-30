package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.xt.entity.Cat;
/**
 * 函数式声明接口的示例：比较器
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月30日]
 * @since V1.00
 */
public class Test3
{
    public static void main(String[] args)
    {
        List<Cat> cats=new ArrayList<>();
        cats.add(new Cat("mike"));
        cats.add(new Cat("jerry"));
        cats.add(new Cat("andy"));
        cats.add(new Cat("kitty"));
        //JDK8之前，使用匿名类
//        Collections.sort(cats,new Comparator<Cat>()
//        {
//            @Override
//            public int compare(Cat o1, Cat o2)
//            {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
        //JDK8可以使用声明式接口,lambda表达式
        Collections.sort(cats,
            (o1,o2)->o1.getName().compareTo(o2.getName()));
        for(Cat t:cats) {
            System.out.println(t.getName());
        }
        
    }
    
}
