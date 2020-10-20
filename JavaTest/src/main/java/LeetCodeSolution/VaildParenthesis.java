package LeetCodeSolution;

import java.util.ArrayDeque;
import java.util.Deque;

public class VaildParenthesis {
    public static boolean isValid(String s) {
        if(s == null || s.length() == 0 ) return true;
        Deque<Character> de = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c=='('){de.push(')');}
            else if(c=='['){de.push(']');}
            else if(c=='{'){de.push('}');}
            else if(de.isEmpty() || c != de.pop()){return false;}
        }
        return de.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{}[]()";
        System.out.println(isValid(s));
    }
}
