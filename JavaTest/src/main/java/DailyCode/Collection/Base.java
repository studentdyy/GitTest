package DailyCode.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Base {
    /*
    java的java.util包主要提供了以下三种类型的集合：
    List:一种有序列表的集合，例如，按索引排列的Student的List；
    Set:一种保证没有重复元素的集合，例如，所有无重复名称的Student的Set；
    Map:一种通过键值（key-value）查找的映射表集合，例如，根据Student的name查找对应Student的Map。
    */

    /*
    List<E> 接口的几个主要方法
    在末尾添加元素：boolean add（E e）;
    在指定索引添加一个元素：boolean add（int index,E e）;
    删除指定索引的元素：int remove(Int index);
    删除某个元素：int  remove（Object e）;
    获取指定索引的元素：E get（int index）;
    获取链表大小（包含元素的个数）：int size（）;

    比较ArrayList 和 LinkedList
                        ArrayList       LinkedList
    获取指定元素	        速度很快	        需要从头开始查找元素
    添加元素到末尾	    速度很快	        速度很快
    在指定位置添加/删除	需要移动元素	    不需要移动元素
    内存占用	            少	            较大
    */


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");//size = 1
        list.add("Apple");//size = 2  允许添加重复元素
        list.add(null);//允许添加null
        list.add("Banana");
    /*
    使用迭代器Iterator来访问List
    Iterator对象有两个方法，boolean hasNext()判断是否有下一个元素，E next（）返回下一个元素
    */

        for(Iterator<String> i = list.iterator();i.hasNext();){
            String s = i.next();
            System.out.println(s);
        }
        //通过Iterator遍历List永远是最高效的方式
        //Java的for each循环本身就可以帮我们使用Iterator遍历
        //可以将上述代码改成下面的形式
        for(String s : list){
            System.out.println(s);
        }
        //实际上实现Iterable接口的集合类都可以直接使用for each来循环，
        //原因在于Iterable定义了一个Iterator<E> iterator()方法，强迫集合类必须返回一个Iterator实例



    }
}
