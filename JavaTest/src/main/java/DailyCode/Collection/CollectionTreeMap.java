package DailyCode.Collection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/*
使用TreeMap时，放入的Key必须实现Comparable接口。
String、Integer这些类已经实现了Comparable接口，因此可以直接作为Key使用。

还有一种Map，它在内部会对Key进行排序，这种Map就是SortedMap。注意到SortedMap是接口，它的实现类是TreeMap。
       ┌───┐
       │Map│
       └───┘
         ▲
    ┌────┴─────┐
    │          │
┌───────┐ ┌─────────┐
│HashMap│ │SortedMap│
└───────┘ └─────────┘
               ▲
               │
          ┌─────────┐
          │ TreeMap │
          └─────────┘


*/
public class CollectionTreeMap {
    public static void main(String[] args) {
        Map<String,Integer> map1 = new TreeMap<>();
        map1.put("orange",1);
        map1.put("apple",2);
        map1.put("pear",3);
        for (String key : map1.keySet()) {
            System.out.println(key);
        }
        //如果作为Key的class没有实现Comparable接口，那么，必须在创建TreeMap时同时指定一个自定义排序算法：
        //TreeMap不使用equals()和hashCode();
        Map<Person,Integer> map2 = new TreeMap<>(
                new Comparator<Person>() {
                    @Override
                    public int compare(Person p1, Person p2) {
                        return p1.name.compareTo(p2.name);
                    }
                }
        );
        map2.put(new Person("Tom"),1);
        map2.put(new Person("Bob"),2);
        map2.put(new Person("Lily"),3);
        for (Person p : map2.keySet()) {
            System.out.println(p);
        }

    }

}
class Person {
    public String name;
    Person(String name) {
        this.name = name;
    }
    public String toString() {
        return "{Person: " + name + "}";
    }
}
/*
SortedMap在遍历时严格按照Key的顺序遍历，最常用的实现类是TreeMap；

作为SortedMap的Key必须实现Comparable接口，或者传入Comparator；

要严格按照compare()规范实现比较逻辑，否则，TreeMap将不能正常工作。
*/