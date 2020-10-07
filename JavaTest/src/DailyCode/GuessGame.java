package DailyCode;

import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("选择您的出招：1，拳头；2，剪刀；3，布");
        int palyerChoice = sc.nextInt();
        int computerChoidce = 1 + (int)(Math.random() * 3);
        switch (palyerChoice){
            case 1:
                System.out.println("玩家出招为：拳头");
                switch (computerChoidce){
                    case 1:
                        System.out.println("电脑出招为：拳头");
                        System.out.println("平局");
                        break;
                    case 2:
                        System.out.println("电脑出招为：剪刀");
                        System.out.println("玩家获胜");
                        break;
                    case 3:
                        System.out.println("电脑出招为：布");
                        System.out.println("电脑获胜");
                        break;
                }
                break;
            case 2:
                System.out.println("玩家出招为：剪刀");
                switch (computerChoidce){
                    case 1:
                        System.out.println("电脑出招为：拳头");
                        System.out.println("电脑获胜");
                        break;
                    case 2:
                        System.out.println("电脑出招为：剪刀");
                        System.out.println("平局");
                        break;
                    case 3:
                        System.out.println("电脑出招为：布");
                        System.out.println("玩家获胜");
                        break;
                }
                break;
            case 3:
                System.out.println("玩家出招为：布");
                switch (computerChoidce){
                    case 1:
                        System.out.println("电脑出招为：拳头");
                        System.out.println("玩家获胜");
                        break;
                    case 2:
                        System.out.println("电脑出招为：剪刀");
                        System.out.println("电脑获胜");
                        break;
                    case 3:
                        System.out.println("电脑出招为：布");
                        System.out.println("平局");
                        break;
                }
                break;
        }
    }
}
