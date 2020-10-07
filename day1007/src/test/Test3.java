package test;

import java.util.Arrays;

/**
 * 流式编程示例3
 * @author  杨卫兵
 * @version  [V1.00, 2020年10月7日]
 * @since V1.00
 */
public class Test3
{
    public static void main(String[] args)
    {
        int []arr= {3,6,12,9,3,6,8,4};
        Arrays.stream(arr).filter(n->n%3==0).forEach(System.out::println);
    }
}
