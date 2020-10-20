package LeetCodeSolution;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {
        return modify(S).equals(modify(T));
    }
    public static String modify(String str){
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for(int i = 0; i <length;++i){
            char ch = str.charAt(i);
            if(ch != '#'){
                ret.append(ch);
            }else {
                if(ret.length()>0){
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "a##c";
        String t = "c#d#";
        System.out.println(BackspaceStringCompare.backspaceCompare(s,t));
    }
}
