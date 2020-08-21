package test;

import java.util.Scanner;

/**
 * 异常示例：自行通过代码进行判断
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年8月20日]
 * @since V1.00
 */
public class Test1
{
    static int a=10;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("pls input:");
        if (scanner.hasNextInt())
        {
            int a = scanner.nextInt();
            System.out.println("pls input:");
            
            int b = scanner.nextInt();
            if (b != 0)
            {
                int c = a / b;
                System.out.printf("%d/%d=%d\n", a, b, c);
            }
            else
            {
                System.out.println("除数为0");
            }
        }
        else {
            System.out.println("输入的不是整数");
        }
        scanner.close();
        
    }
    
}
