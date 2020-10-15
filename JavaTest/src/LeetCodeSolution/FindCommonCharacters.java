package LeetCodeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    public static List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if(A == null || A.length == 0){
            return res;
        }
        int len = A.length;
        int[][] arr = new int[len][26];
        //记录所有字符串'a' --'z'出现的次数
        for(int i = 0; i < len; i++){
            char[] tmp = A[i].toCharArray();
            for(int j = 0; j < tmp.length; j++){
                arr[i][tmp[j] - 'a']++;
            }
        }
        //统计'a' --'z'出现的次数
        int flag = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            flag = Integer.MAX_VALUE;
            for(int j = 0; j < len; j++){
                flag = Math.min(arr[j][i], flag);
            }
            while(flag-- > 0){
                res.add(String.valueOf((char)('a' + i)));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String[] s = {"bella","label","roller"};
        List<String> l = FindCommonCharacters.commonChars(s);
        System.out.println(l.toString());
        System.out.println('a' - 'b');
    }
}
