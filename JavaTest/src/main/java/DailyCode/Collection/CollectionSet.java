package DailyCode.Collection;

import java.util.*;


public class CollectionSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println(set.add("abc"));
        System.out.println(set.add("xyz"));
        System.out.println(set.add("xyz"));
        System.out.println(set.contains("xyz"));
        System.out.println(set.remove("hello"));
        System.out.println(set.size());


        //练习
        //asList方法 只读
        List<Message> received = Arrays.asList(
             new Message(1,"Hello！"),
             new Message(5,"发工资了吗？"),
             new Message(5,"发工资了吗？"),
             new Message(3,"去哪吃饭?"),
             new Message(3,"去哪吃饭?"),
             new Message(4,"Bye")
        );
        List<Message> displayMessages = process(received);
        for(Message m : displayMessages){
            System.out.println(m.text);
        }
    }

    private static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        //重写排序逻辑Comparator
        Set<Message> set = new TreeSet<>(new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o1.sequence - o2.sequence;
            }
        });
//        for(Message m : received){
//            if(set.add(m)){
//                set.add(m);
//            }
//        }
        //特么直接用addALL完事了 无语
        set.addAll(received);
        return new ArrayList<>(set);
    }


}
class Message{
    public final int sequence;
    public final String text;
    Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}