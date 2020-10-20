package DailyCode.RegularExpression;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "ab  b , ;; c";
        String[] a = s.split("[\\,\\;\\s]+");
        System.out.println(Arrays.toString(a));
    }
}
