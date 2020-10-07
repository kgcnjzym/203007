package test;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import com.xt.entity.Student;

/**
 * 流式编程示例4
 * @author  杨卫兵
 * @version  [V1.00, 2020年10月7日]
 * @since V1.00
 */
public class Test4
{
    public static void main(String[] args)
    {
        List<Student> lst=new ArrayList<>();
        lst.add(new Student(18,"mike"));
        lst.add(new Student(19,"jerry"));
        lst.add(new Student(20,"andy"));
        lst.add(new Student(17,"tom"));
        lst.add(new Student(21,"john"));
        //求出年龄和
        //方式1：降解
        int sum=lst.stream().mapToInt(
            st->st.getAge()).reduce(
                0,(a,b)->a+b);
        System.out.println(sum);
        //方式2：统计
        IntSummaryStatistics statistics = lst.stream().mapToInt(
            st->st.getAge()).summaryStatistics();
        System.out.println(statistics.getSum());
        System.out.println("=============");
        //输出年龄<20的学生姓名
        lst.stream().filter(
            st->st.getAge()<20).forEach(
                st->System.out.println(st.getName()));
        System.out.println("=============");
        //List的收集
//        List<Student> subList = lst.stream().filter(
//            st->st.getAge()<20).collect(ArrayList::new, 
//                ArrayList::add, ArrayList::addAll);
        List<Student> subList = lst.stream().filter(
            st->st.getAge()<20).collect(Collectors.toList());
        subList.stream().forEach(System.out::println);
        subList.stream().forEach(st->System.out.println(st.getAge()));
        
    }
}





