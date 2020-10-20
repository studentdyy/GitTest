package DailyCode.Reflection;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Foundation {
    /*

    * */
    public static void main(String[] args) throws Exception {
        //获取一个class的class实例
        //方法一 直接通过一个class的静态变量获取
        Class c1 = String.class;

        //方法二 如果我们有一个实例变量，可以通过getclass方法获取
        String s = "Hello";
        Class cl = s.getClass();

        //方法三 如果知道一个class的完整类名，可以通过静态方法forname获取
        Class cls = Class.forName("java.lang.String");

        Class stdClass = Student.class;
        //获取public字段“score”
        System.out.println(stdClass.getField("score"));
        //获取继承的public字段“name”
        System.out.println(stdClass.getField("name"));
        //获取private字段“grade”
        System.out.println(stdClass.getDeclaredField("grade"));

        /*
        * 一个Field对象包含了一个字段的所有信息：
        getName()：返回字段名称，例如，"name"；
        getType()：返回字段类型，也是一个Class实例，例如，String.class；
        getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
        * */

        /*
        * 以String类的value字段为例，它的定义是：
        * public final class String {
          private final byte[] value;}
        */
        Field f = String.class.getDeclaredField("value");
        f.getName();
        System.out.println(f.getType());
        int m = f.getModifiers();
        Modifier.isFinal(m); // true
        Modifier.isPublic(m); // false
        Modifier.isProtected(m); // false
        Modifier.isPrivate(m); // true
        Modifier.isStatic(m); // false

        //通过反射的方式设置实例的字段值
        Person p = new Person("XiaoHong");

        Class c2 = p.getClass();
        Field f2 = c2.getDeclaredField("name");
        f2.setAccessible(true);//设置ture可以访问private修饰符修饰的字段
        f2.set(p,"XiaoYang");
        System.out.println(p.getName());


    }
}

class Student extends Person {
    public int score;
    private int grade;

    public Student(String name) {
        super(name);
    }
    public int getScore(String type) {
        return 99;
    }
    private int getGrade(int year) {
        return 1;
    }
}
class Person{
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public Person(){}

    public String getName(){
        return this.name;
    }

    private void getPrivateName(String name){
        this.name = name;
    }
}