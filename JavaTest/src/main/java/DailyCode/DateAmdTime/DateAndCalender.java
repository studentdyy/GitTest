package DailyCode.DateAmdTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
标准库API
我们再来看一下Java标准库提供的API。Java标准库有两套处理日期和时间的API：

一套定义在java.util这个包里面，主要包括Date、Calendar和TimeZone这几个类；
一套新的API是在Java 8引入的，定义在java.time这个包里面，主要包括LocalDateTime、ZonedDateTime、ZoneId等。
*/
public class DateAndCalender {
    public static void main(String[] args) {
        Date date = new Date();
        //注意getYear()返回的年份必须加上1900，getMonth()返回的月份是0~11分别表示1~12月，所以要加1，而getDate()返回的日期范围是1~31，又不能加1
        System.out.println(date.getYear() + 1900); // 必须加上1900
        System.out.println(date.getMonth() + 1); // 0~11，必须加上1
        System.out.println(date.getDate()); // 1~31，不能加1
        //转换为String
        System.out.println(date.toString());
        //转换为GMT时区
        System.out.println(date.toGMTString());
        //转换为本地时区
        System.out.println(date.toLocaleString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));

    /*
    Calendar
Calendar可以用于获取并设置年、月、日、时、分、秒，它和Date比，主要多了一个可以做简单的日期和时间运算的功能。

我们来看Calendar的基本用法：
    */

        //Calendar只有一种方式获取，即Calendar.getInstance()，而且一获取到就是当前时间。
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = 1 + c.get(Calendar.MONTH);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int w = c.get(Calendar.DAY_OF_WEEK);
        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);
    }
}
/*
计算机表示的时间是以整数表示的时间戳存储的，即Epoch Time，Java使用long型来表示以毫秒为单位的时间戳，通过System.currentTimeMillis()获取当前时间戳。

Java有两套日期和时间的API：

旧的Date、Calendar和TimeZone；
新的LocalDateTime、ZonedDateTime、ZoneId等。
分别位于java.util和java.time包中。
*/