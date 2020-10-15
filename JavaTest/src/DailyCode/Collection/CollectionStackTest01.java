package DailyCode.Collection;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Stack只有入栈和出栈的操作：

把元素压栈：push(E)；
把栈顶的元素“弹出”：pop(E)；
取栈顶元素但不弹出：peek(E)。

在Java中，我们用Deque可以实现Stack的功能：

把元素压栈：push(E)/addFirst(E)；
把栈顶的元素“弹出”：pop(E)/removeFirst()；
取栈顶元素但不弹出：peek(E)/peekFirst()。
*/
public class CollectionStackTest01 {
    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }


    static String toHex(int n) {
        Deque<String> stack = new ArrayDeque<>();
        int temp = 0;
        if(n == 0) return null;
        while(n != 0){
            temp = n % 16;
            String s = Integer.toHexString(temp);
//            d.push(temp);
            stack.push(s);
            n /= 16;
        }
//        return CollectionStack.Trans(d);
        String sHex = "";
        while(!stack.isEmpty()){
            sHex += stack.pop();
        }
        return sHex;
    }

    static String Trans(Deque<Integer> d){
        String s = "";
        for(Integer i : d){
            switch (i){
                case 10:
                    s = s+"A";
                    break;
                case 11:
                    s = s+"B";
                    break;
                case 12:
                    s = s+"C";
                    break;
                case 13:
                    s = s+"D";
                    break;
                case 14:
                    s = s+"E";
                    break;
                case 15:
                    s = s+"F";
                    break;
                default:s = s+i;
            }
        }
        return s;
    }
}

