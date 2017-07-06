package base;

import org.junit.Test;

/**
 * Created by mercop on 2017/7/5.
 */
public class InnerClassTest {

    @Test
    public void test(){
        ClassA classA = new ClassA();

        //内部类的初始化
        ClassA.ClassB classB = classA.new ClassB("Guo bin");
        classB.print();

        //静态内部类
        ClassA.ClassC.print();
    }
}

class ClassA{

    private String name;

    {
        name = "Zhang";
        //给静态内部类赋值
        ClassC.nameC = "Li";
    }

    public class ClassB{
        private String nameB;
        public ClassB(String nameB){
            this.nameB = nameB;
        }
        public void print(){

            System.out.println(this.nameB);
            //获取外部类变量
            System.out.println(ClassA.this.name);
        }
    }

    public static class ClassC{
        public static String nameC;

        public static void print(){
            System.out.println(nameC);
        }
    }
}
