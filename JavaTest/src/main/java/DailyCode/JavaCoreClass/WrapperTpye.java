package DailyCode.JavaCoreClass;

public class WrapperTpye {
    public static void main(String[] args) {
        /*
        * 所有包装类都是不变类,有以下两个特点
        * 定义class时使用final，无法派生子类；
          每个字段使用final，保证创建实例后无法修改任何字段
        * 自动装箱和自动拆箱都是在编译期完成的（JDK>=1.5）；
        * 包装类型的比较必须使用equals()；
        * 整数和浮点数的包装类型都继承自Number；
        * 例如Integer源码
        * public final class Integer {
            private final int value;
          }
        *
        * boolean	java.lang.Boolean
          byte	    java.lang.Byte
          short	    java.lang.Short
          int	    java.lang.Integer
          long	    java.lang.Long
          float	    java.lang.Float
          double	java.lang.Double
          char	    java.lang.Character
          *
          *
        * */

        /*
        * 方法2更好，因为方法1总是创建新的Integer实例，
        * 方法2把内部优化留给Integer的实现者去做，
        * 即使在当前版本没有优化，
        * 也有可能在下一个版本进行优化。
        * */
        Integer i1 = new Integer(100);
        Integer i2 = Integer.valueOf(100);


        System.out.println(Integer.toString(100)); // "100",表示为10进制
        System.out.println(Integer.toString(100, 36)); // "2s",表示为36进制
        System.out.println(Integer.toHexString(100)); // "64",表示为16进制
        System.out.println(Integer.toOctalString(100)); // "144",表示为8进制
        System.out.println(Integer.toBinaryString(100)); // "1100100",表示为2进制
    }
}
