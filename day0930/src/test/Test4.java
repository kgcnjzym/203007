package test;

import java.io.File;

/**
 * 函数式声明接口的示例：文件过滤器
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月30日]
 * @since V1.00
 */
public class Test4
{
    public static void main(String[] args)
    {
        File file=new File("/Users/yangweibing/kgc_demo/203007/works/day0905/src/com/xt/entity");
        if(!file.exists()) {
            System.out.println("not exists");
            return;
        }
        if(file.isFile()) {
            System.out.println("not directory");
            return;
        }
        //JDK8之前
//        File []fs=file.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname)
//            {
//                return pathname.isFile() && pathname.getName().endsWith(".java");
//            }
//        });
        //JDK8使用声明式接口实现文件过滤
        File []fs=file.listFiles(
            pn->pn.isFile() && pn.getName().endsWith(".java"));
        for (int i = 0; i < fs.length; i++)
        {
            System.out.println(fs[i].getName());
        }
        //JDK8使用声明式接口实现多线程
        new Thread(()->{
            System.out.println("this is thread");
            System.out.println("name:"+Thread.currentThread().getName());
        },"myth").start();
    }
    
}
