package DailyCode.JavaCoreClass;

import java.util.Arrays;

public class StringAndCode {
    public static void main(String[] args) {
        /*
        * 字符串比较：当我们想要比较两个字符串是否相同时，要使用equals()而不是==
        * Java的String和char在内存中总是以Unicode编码表示。
        * Java字符串String是不可变对象；
        * 字符串操作不改变原字符串内容，而是返回新字符串
        * 转换编码就是将String和byte[]转换，需要指定编码；
        * 转换为byte[]时，始终优先考虑UTF-8编码
        * */

        //分割字符串
        String s1 = "A,B,C,D";
        String[] ss = s1.split("\\,");
        System.out.println(Arrays.toString(ss));

        //拼接字符串
        String[] arr = {"A","B","D","C"};
        String s2 = String.join("*",arr);
        System.out.println(s2);

        //替换字符串
        String s3 = s1.replace('A','a');
        System.out.println(s3);

        //格式化字符串
        /*
        * %s:显示字符串
        * %d:显示整数
        * %f:显示浮点数
        * */
        System.out.printf("Hi %s, your score is %d%n","Alice",80);

        //StringBuilder
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(insert);
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }
    static String buildInsertSql(String table, String[] fields) {
        // TODO:
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ")
                .append(table)
                .append(" (")
                .append(String.join(", ",fields))
                .append(") ")
                .append("VALUES (?, ?, ?)");
        return sb.toString();
    }



}
