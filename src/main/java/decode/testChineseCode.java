package decode;

/**
 * Created by mercop on 2017/6/27.
 */
public class testChineseCode {
    public static void main(String[] args) {
        String firstName = "赵钱孙李周吴郑王林杨柳刘孙陈江阮侯邹高彭徐";
        int i = 0;
        for(;i< firstName.length()-1;i++){
            String str = firstName.substring(i,i+1) ;
            System.out.println(str + "First Byte: " + str.getBytes()[0] +" second byte:" + str.getBytes()[1]);
        }
    }
}
