package solution.JZOffer;

/**
 * Created by mercop on 2017/7/4.
 * 获取n，0-n中1的个数 = n
 */
public class NumOf1 {


    public static void main(String[] args) {
        int n = 9;
        int res = 1;
        int temp;
        while(n!=((temp = getNumOf1(n)) + res)){
          res += temp;
          n ++;
        }
        System.out.println(n);
    }

    static int getNumOf1(int n){
        int num = 0;
        String str = Integer.toString(n);
        for(char c : str.toCharArray()){
            if(c =='1')
                num++;
        }
        return num;
    }
}
