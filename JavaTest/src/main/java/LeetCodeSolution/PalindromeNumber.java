package LeetCodeSolution;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int flag = x;
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int ans = 0;
        while(x != 0){
            int temp = x % 10;
            x /= 10;
            ans = ans * 10 + temp;
        }
        return ans == flag ? true : false;
    }

    public static void main(String[] args){
        PalindromeNumber lcs = new PalindromeNumber();
        System.out.println(lcs.isPalindrome(121));
    }
}
