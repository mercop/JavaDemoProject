package base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 17-6-29.
 */
public class ArrayTest {

    public static void main(String[] args) {
        long start =System.currentTimeMillis();
        Integer[][] integers = new Integer[100000][5] ;
        System.out.println(System.currentTimeMillis() - start);

        Integer[] integers1 = null;
        start =System.currentTimeMillis();
        for(int i = 0 ; i< 100000;i ++)

            integers1 = new Integer[5];
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void testArrayList(){
        TestClass testClass1 = new TestClass("Test");
        TestClass testClass2 = new TestClass("Test");
        TestClass testClass3 = new TestClass("Test");
        Object testClass4 = new TestClass("Test");
        List<TestClass> list = new ArrayList<TestClass>();
        list.add(testClass1);
        //return true;
        System.out.println(list.contains(testClass2));
        //return true;
        System.out.println(testClass1.equals(testClass2));
        //return true;
        System.out.println(testClass3.equals(testClass4));
    }
}
class TestClass{
    private String value = null;

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        else if(obj instanceof TestClass){
            TestClass testClass = (TestClass) obj;
            return value.equals(testClass.value);
        }
        return false;
    }

    public TestClass(String value){
        this.value = value;
    }

}
