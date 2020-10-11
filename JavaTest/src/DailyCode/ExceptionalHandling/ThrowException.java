package DailyCode.ExceptionalHandling;

public class ThrowException {
    /*
    * 捕获到异常并再次抛出时，
    * 一定要留住原始异常，
    * 否则很难定位第一案发现场！
    *
    * JVM会先执行finally，然后抛出异常。
    *
    *
    * */
    public static void main(String[] args) {
        try {
            //成员变量定义使用空字符串""而不是默认的null可避免很多NullPointerException
            String name = "";

            process1();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }

    static void process1(){
        try {
            process2();
        }catch (NullPointerException e){
            throw new IllegalArgumentException(e);
        }
    }

    static void process2(){
        throw new NullPointerException();
    }
}
