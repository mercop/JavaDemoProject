package base;

import org.junit.Test;

import java.io.*;

/**
 * Created by mercop on 2017/7/4.
 */
public class SerializableTest {

    @Test
    public void test1() throws IOException {
        MyClass myClass = new MyClass();
        myClass.id = "100";
        myClass.age = "12";
        //myClass.name ="Guo Bin";
        myClass.remark = "123456";
        //序列化对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(System.out);
        objectOutputStream.writeObject(myClass);

    }
}

class MyClass implements Serializable{

    public String id;
    private String name = "Guo bin ";
    public String age;
    //transient字段不被序列化
    public transient String remark;

}
