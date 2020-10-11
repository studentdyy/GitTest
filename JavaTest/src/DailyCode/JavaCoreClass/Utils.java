package DailyCode.JavaCoreClass;

import java.security.SecureRandom;
import java.util.Random;

public class Utils {
    public static void main(String[] args) {
        /*
        * Math.abs(-100) //100
        * Math.abs(-7.8) //7.8
        *
        * Math.max(99,100) //100
        * Math.min(99,100) //99
        * */

        double pi = Math.PI;
        double e = Math.E;
        System.out.println(pi);

        //生产随机数
        double x = Math.random();
        double y = x * 50;//0 <= x < 1 -->  0 <= x < 50
        long z = (long)y;
        System.out.println(y);
        System.out.println(z);

        //Random 伪随机数
        Random r = new Random(12345);//种子为12345
        for(int i = 0; i < 10; i++){
            System.out.print(r.nextInt(100)+",");//范围[o,n]
        }

        System.out.printf("%n===========================%n");
        //真随机数
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.nextInt());



    }
}
