package DailyCode.JavaCoreClass;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class JavaBean {
    /*
    * 如果读写方法符合以下这种命名规范：
    * // 读方法:
    * public Type getName()
    * // 写方法:
    * public void setName(Type value)
    * 那么这种class被称为JavaBean：
    *
    * */
    public static void main(String[] args) throws Exception{
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()){
            System.out.println(pd.getName());
            System.out.println("    " + pd.getReadMethod());
            System.out.println("    " + pd.getWriteMethod());
        }
    }
}
class Person{
    String name;
    int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}