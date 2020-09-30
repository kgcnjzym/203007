package test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.xt.entity.Cat;
import com.xt.entity.Dog;
import com.xt.entity.Pet;
import com.xt.factory.PetFactory;

/**
 * 函数引用示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月30日]
 * @since V1.00
 */
public class Test2
{
    public static void main(String[] args)
    {
        Pet pet=PetFactory.createPet(Dog::new);
        System.out.println(pet);
        pet=PetFactory.createPet(Cat::new,"kitty");
        System.out.println(pet);
        Cat cat=(Cat)pet;
        System.out.println(cat.getName());
        //实例方法通过对象指向
        test1(cat::getName);
        System.out.println("=======");
        //静态方法通过类名指向
        test2(Cat::intro,5);
        System.out.println("=======");
        //实例方法如果要通过类名指向，则需增加一个对象参数
        test3(Cat::getName,cat);
    }
    private static void test1(Supplier<String> sup) {
        System.out.println("in test1:"+sup.get());
    }
    private static void test2(Consumer<Integer> cons,Integer num) {
        cons.accept(num);
    }
    private static void test3(Function<Cat,String> func,Cat t) {
        System.out.println(func.apply(t));
    }
    
}
