package DailyCode.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CallMethod {
    public static void main(String[] args) throws Exception {
        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));

        /*
        * 一个Method对象包含一个方法的所有信息：
        getName()：返回方法名称，例如："getScore"；
        getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
        getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
        getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。
        * */
        String s = "Hello word";
        String r1 = s.substring(6);
        Method m1 = String.class.getMethod("substring", int.class,int.class);
        String r2 = (String) m1.invoke(s,6,7);
        System.out.println(r1.equals(r2));

        //调用静态方法时，由于无需指定实例对象，所以invoke方法传入的第一个参数永远为null
        // 获取Integer.parseInt(String)方法，参数为String:
        Method m2 = Integer.class.getMethod("parseInt", String.class);
        // 调用该静态方法并获取结果:
        Integer n = (Integer) m2.invoke(null, "12345");
        // 打印调用结果:
        System.out.println(n);

        Person p = new Person();
        Method m = p.getClass().getDeclaredMethod("getPrivateName",String.class);
        m.setAccessible(true);
        m.invoke(p,"啦啦啦阿联");
        System.out.println(p.name);

        //调用构造方法
        Constructor cons1 = Integer.class.getConstructor(int.class);
        Integer i1 = (Integer) cons1.newInstance(123);
        System.out.println(i1);
    }
}
