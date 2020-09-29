import java.util.Scanner;

public class Foundation {
    public static void main(String[] args){
        /*
        * 整数类型：byte(1字节)，short（2字节），int（4），long（8）
        * 浮点数类型：float(4，f),double（8）
        * 字符类型：char（2）
        * 布尔类型：boolean
        * 引用类型：string
        * */
//      练习
        boolean bo = 5 < 3;
        boolean result = bo && (5 / 0 > 0);
        System.out.println(result);

//      三元运算符
        int age = 7;
        boolean isPrimaryStudent = age >=6 && age <= 13;
        System.out.println(isPrimaryStudent ? "Yes" : "No");

//      字符串练习
        int a = 72;
        int b =105;
        int c = 65281;
        String s = ""+(char)a+(char)b+(char)c;
        System.out.println(s);

//      格式化练习
        Scanner sc = new Scanner(System.in);
        System.out.println("input your last exam result");
        int examLastResult = sc.nextInt();
        System.out.println("input your this exam result");
        int examThisResult = sc.nextInt();
        double impovePercentage = ((double)examThisResult - (double)examLastResult) / (double)examLastResult * 100;
        String pick = examThisResult > examLastResult ? "提高" : "降低";
        impovePercentage = impovePercentage > 0 ? impovePercentage : -impovePercentage;
        System.out.printf("上次的考试成绩%s,这次的考试成绩%s,%s了%.2f%%"
                ,examLastResult,examThisResult,pick,impovePercentage);

    }
}
