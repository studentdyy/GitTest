package DailyCode.Collection;

import java.util.*;

/*
队列（Queue）是一种经常使用的集合。Queue实际上是实现了一个先进先出（FIFO：First In First Out）的有序表。
只有两个操作
把元素添加到队列末尾；

从队列头部取出元素。
*/
public class CollectionQueue {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<String>();
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        // 队首永远都是apple，因为peek()不会删除它:
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
        // 从队列取出元素:
        System.out.println(q.poll()); // pear
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()); // null,因为队列是空的
        System.out.println("====================================");

        //设置的队列优先级
        Queue<User> q2 = new PriorityQueue<>(new UserComparator());
        q2.offer(new User("Bob", "A1"));
        q2.offer(new User("Alice", "A2"));
        q2.offer(new User("Boss", "V1"));
        System.out.println(q2.poll()); // Boss/V1
        System.out.println(q2.poll()); // Bob/A1
        System.out.println(q2.poll()); // Alice/A2
        System.out.println(q2.poll()); // null,因为队列为空

        System.out.println("====================================");
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A"); // A
        deque.offerLast("B"); // B -> A
        deque.offerFirst("C"); // B -> A -> C
        System.out.println(deque.pollFirst()); // C, 剩下B -> A
        System.out.println(deque.pollLast()); // B
        System.out.println(deque.pollFirst()); // A
        System.out.println(deque.pollFirst()); // null
    }
}
class UserComparator implements Comparator<User> {

    @Override
    public int compare(User u1,User u2) {
        if(u1.number.charAt(0) == u2.number.charAt(0)){
            return u1.number.compareTo(u2.number);
        }
        if(u1.number.charAt(0) == 'V'){
            return -1;
        }else return 1;
    }
}

class User{
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}