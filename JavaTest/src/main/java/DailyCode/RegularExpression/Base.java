package DailyCode.RegularExpression;
/*
如果想匹配非ASCII字符，例如中文，那就用的十六进制表示，例如：a\u548cc匹配字符串"a和c"，中文字符和的Unicode编码是548c。

用.可以匹配任意字符，这个口子开得有点大。如果我们只想匹配0~9这样的数字，可以用\d匹配。

用\w可以匹配一个字母、数字或下划线，w的意思是word

用\s可以匹配一个空格字符，注意空格字符不但包括空格，还包括tab字符（在Java中用\t表示）。例如，a\sc可以匹配：
"a c"，因为\s可以匹配空格字符；
"a c"，因为\s可以匹配tab字符\t。
它不能匹配"ac"，"abc"等。


匹配非数字
用\d可以匹配一个数字，而\D则匹配一个非数字。例如，00\D可以匹配：

"00A"，因为\D可以匹配非数字字符A；
"00#"，因为\D可以匹配非数字字符#。
00\d可以匹配的字符串"007"，"008"等，00\D是不能匹配的。


*/

import java.util.Arrays;
import java.util.List;

public class Base {
    public static void main(String[] args) {
        String regex= "20\\d\\d";
        System.out.println("2019".matches(regex));
        System.out.println("2100".matches(regex));


        String re = "\\d{3,4}\\-\\d{7,8}";
        for (String s : Arrays.asList("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        for (String s : Arrays.asList("010 12345678", "A20-9999999", "0755-7654.321")) {
            if (s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
    }

}
/*
复杂匹配规则主要有:
正则表达式	            规则	                可以匹配
^	                    开头	                字符串开头
$	                    结尾	                字符串结束
[ABC]	                […]内任意字符	    A，B，C
[A-F0-9xy]	            指定范围的字符	    A，……，F，0，……，9，x，y
[^A-F]	                指定范围外的任意字符   非A~F
AB|CD|EF	            AB或CD或EF	        AB，CD，EF
*/