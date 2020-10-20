package DailyCode.Collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Map<K, V>是一种键-值映射表,Key的值只能存在一个

要正确使用HashMap，作为key的类必须正确覆写equals()和hashCode()方法；
一个类如果覆写了equals()，就必须覆写hashCode()，并且覆写规则是：
如果equals()返回true，则hashCode()返回值必须相等；
如果equals()返回false，则hashCode()返回值尽量不要相等,避免哈希冲突
实现hashCode()方法可以通过Objects.hashCode()辅助方法实现。
*/
public class CollectionOfMap {
    public static void main(String[] args) {
        //对Map来说，要遍历key可以使用for each循环遍历Map实例的keySet()方法返回的Set集合，它包含不重复的key的集合
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);
        for(String key : map.keySet()){
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }

        //同时遍历key和value
        for(Map.Entry<String, Integer> m : map.entrySet()){
            String key = m.getKey();
            Integer value = m.getValue();
            System.out.println(key + "=" + value);
        }
        //遍历Map时，不可假设输出的key是有序的！


        //练习题
        List<Student> list = Arrays.asList(
                new Student("Bob",78),
                new Student("Alice",85),
                new Student("Brush",66),
                new Student("Newton",99)
        );
        Students holder = new Students(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 86 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
    }

}
class Students{
    List<Student> list ;
    Map<String,Integer> cache;

    public Students(List<Student> list) {
        this.list = list;
        cache = new HashMap<>();
        for(Student flag : list){
            String name = flag.getName();
            Integer score = flag.getScore();
            cache.put(name,score);
        }
    }
    /**
     * 根据name查找score，找到返回score，未找到返回-1
     * */
    int getScore(String name){
        Integer score = this.cache.get(name);
        if(score == null){
            //TODO
            return -1;
        }
        return score = score.intValue();
    }
}

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}