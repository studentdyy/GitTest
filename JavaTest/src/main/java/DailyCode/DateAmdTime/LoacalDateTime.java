package DailyCode.DateAmdTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*
从Java 8开始，java.time包提供了新的日期和时间API，主要涉及的类型有：

本地日期和时间：LocalDateTime，LocalDate，LocalTime；
带时区的日期和时间：ZonedDateTime；
时刻：Instant；
时区：ZoneId，ZoneOffset；
时间间隔：Duration。
以及一套新的用于取代SimpleDateFormat的格式化类型DateTimeFormatter
*/
public class LoacalDateTime {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();// 当前日期
        LocalTime t = LocalTime.now();// 当前时间
        LocalDateTime dt = LocalDateTime.now();// 当前日期和时间
        System.out.printf("%s\n%s\n%s",d,t,dt);

    }
}
/*
Java 8引入了新的日期和时间API，它们是不变类，默认按ISO 8601标准格式化和解析；

使用LocalDateTime可以非常方便地对日期和时间进行加减，或者调整日期和时间，它总是返回新对象；

使用isBefore()和isAfter()可以判断日期和时间的先后；

使用Duration和Period可以表示两个日期和时间的“区间间隔”。
*/
