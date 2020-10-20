package LeetCodeSolution;

import java.util.Arrays;

public class SortColors {
    public static int[] sortColors(int[] nums) {
        int flag = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[flag];
                nums[flag] = temp;
                flag++;
            }
        }
        for(int i = flag; i < nums.length;i++){
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[flag];
                nums[flag] = temp;
                flag++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(sortColors(nums)));
    }
}
