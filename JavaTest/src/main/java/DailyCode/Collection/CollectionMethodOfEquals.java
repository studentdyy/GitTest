package DailyCode.Collection;

import DailyCode.Annotation.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CollectionMethodOfEquals {
    public static void main(String[] args) {
/*
要正确使用List的contains()、indexOf()这些方法，
放入的实例必须正确覆写equals()方法，否则，放进去的实例，查找不到。
我们之所以能正常放入String、Integer这些对象，
是因为Java标准库定义的这些类已经正确实现了equals()方法。
*/
        List<People> list = new ArrayList<>();
        list.add(new People("Xiao", "Ming", 18));
        list.add(new People("Xiao", "Hong", 25));
        list.add(new People("Bob", "Smith", 20));

        List<People> list2 = Arrays.asList(new People("Xiao", "Ming", 18), new People("Xiao", "Hong", 25),
                new People("Bob", "Smith", 20));
        boolean exist = list2.contains(new People("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");

    }

}

class People {
    String firstName;
    String lastName;
    int age;
    public People(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof People) {
            People p = (People) o;
            return Objects.equals(this.firstName, p.firstName)
                    && Objects.equals(this.lastName, p.lastName)
                    && this.age == p.age;
        }
        return false;
    }
}

/*
编写equals
自反性（Reflexive）：对于非null的x来说，x.equals(x)必须返回true；
对称性（Symmetric）：对于非null的x和y来说，如果x.equals(y)为true，则y.equals(x)也必须为true；
传递性（Transitive）：对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)也必须为true；
一致性（Consistent）：对于非null的x和y来说，只要x和y状态不变，则x.equals(y)总是一致地返回true或者false；
对null的比较：即x.equals(null)永远返回false。
*/
