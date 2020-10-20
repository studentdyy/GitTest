package DailyCode.JavaCoreClass;

public class Enumerator {
    /*
    * 使用enum定义的枚举类型是一种引用类型
    * 因为enum类型的每个常量在JVM中只有唯一实例,所以可以直接用==比较
    * 判断枚举常量的名字，要始终使用name()方法，绝不能调用toString()！
    * 可以为enum编写构造方法、字段和方法
    * enum的构造方法要声明为private，字段强烈建议声明为final；
    *  */
    public static void main(String[] args) {
        Weekday day = Weekday.SUM;
        if(day.dayValue == 6|| day.dayValue == 7){
            System.out.println(day.name()+" "+day.ordinal()+" "+day.toString()+",wook at home");
        }else {
            System.out.println(day+"wook at offic");
        }
    }
}

enum Weekday{
    SUM(7, "星期天"),
    MON(1, "星期一"),
    TUE(2, "星期二"),
    WED(3, "星期三"),
    THU(4, "星期四"),
    FRI(5, "星期五"),
    SAT(6, "星期六");

    public final int dayValue;
    private final String chinese;

    Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    public String toString(){
        return this.chinese;
    }
}