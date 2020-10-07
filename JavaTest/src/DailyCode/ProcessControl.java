package DailyCode;

import java.util.Scanner;

public class ProcessControl {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的身高（米）");
        double hight = sc.nextDouble();
        System.out.println("请输入您的体重（KG）");
        double weight = sc.nextDouble();
        double IBM = weight / (hight * hight);
        if (IBM < 18.5){
            System.out.println("您的体重属于过轻");
        }else if(IBM>=18.5 && IBM < 25){
            System.out.println("您的体重属于正常");
        }else if(IBM>=25 && IBM < 28){
            System.out.println("您的体重属于过重");
        }else if(IBM>=28 && IBM<=32){
            System.out.println("您的体重属于肥胖");
        }else if(IBM>=32){
            System.out.println("您的体重属于非常肥胖");
        }else{
            System.out.println("您的输入");
        }
        sc.close();

    }
}
