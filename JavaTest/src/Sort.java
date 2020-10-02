import java.util.Arrays;

public class Sort {
    public static void main(String[] args){
        //冒泡排序，i为次数，j为相邻元素直接互相比较
        int[] ns = {28,12,89,73,65,15,95,50,8,36,99,120,4};
        System.out.println(Arrays.toString(ns));
        for(int i = 0; i < ns.length - 1; i++){
            for(int j = 0; j < ns.length - i - 1; j++){
                if(ns[j] > ns[j+1]){
                    int temp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ns));

        //用Arrays对象直接操作
        int[] ds = {26,12,89,70,2,36,69,140,8};
        System.out.println(Arrays.toString(ds));
        Arrays.sort(ds);
        System.out.println(Arrays.toString(ds));
    }
}
