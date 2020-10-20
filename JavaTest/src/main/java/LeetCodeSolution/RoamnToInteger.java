package LeetCodeSolution;

public class RoamnToInteger {
    public static void main(String[] args){
        Solution s = new Solution();
        int result = s.romanToInt("XXVII");
        System.out.println(result);
    }
}
class Solution{
    public  int romanToInt(String s){
        int sum = 0;
        int flag =getInt(s.charAt(s.length() - 1));
        for(int i = 0;i < s.length() - 1;i++){
            int a = getInt(s.charAt(i));
            int b = getInt(s.charAt(i+1));
            if(a < b){
                sum -= a;
            }else{
                sum += a;
            }
        }
        return sum + flag;
    }
    public  int getInt(char c){
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
}