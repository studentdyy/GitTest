package DailyCode.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {
    /**
     * 从"21:05:19"中提取时，分，秒，否则抛出IllegalArgumentException
     */
    public static void main(String[] args) {
        Time.parseTime("21:01:59");

    }
    public static int[] parseTime(String s) {
        // FIXME:
        if (s == null) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("([0-1]\\d|2[0-3]):([0-5][0-9]):([0-5][0-9])");
        Matcher matcher = pattern.matcher(s);
        //使用Matcher时，必须首先调用matches()判断是否匹配成功，匹配成功后，才能调用group()提取子串。
        if (matcher.matches()) {
            Integer hour = new Integer(matcher.group(1));
            Integer minute = new Integer(matcher.group(2));
            Integer second = new Integer(matcher.group(3));
            System.out.print("123");
            return new int[]{hour, minute, second};
        } else {
            throw new IllegalArgumentException();
        }
    }
}
