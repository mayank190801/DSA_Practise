import java.util.*;
import java.io.*;

public class letterCombinations {
    public static void main(String[] args) {
        String digits ="23";
        var ans = letterCombinations(digits);
        String.valueOf(arr);
        System.out.println(ans);
    }



    public static String[] mapping = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0){
            return ans;
        }

        helper(digits, 0, ans, new StringBuilder());
        return ans;
    }

    public static void helper(String digits, int idx, List<String> ans, StringBuilder sb){
        if(idx == digits.length()){
            String cans = sb.toString();
            ans.add(cans);
            return;
        }

        int pos = digits.charAt(idx) - '0';
        for(int i= 0; i < mapping[pos].length(); i++){
            char ch = mapping[pos].charAt(i);
            sb.append(ch);
            helper(digits, idx + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
}
