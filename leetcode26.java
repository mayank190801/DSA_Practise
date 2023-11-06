import java.util.ArrayList;
import java.util.List;

public class leetcode26 {
    public static void main(String[] args) {

    }

    //let's figure this function out and see how we can solve this
    public static List<String> generateParenthesis(int n) {
        //n <= 8 - so it shouldn't be a problem
        List<String> ans = new ArrayList<>();
        solve(n, n, "", ans);
        return ans;
    }

    public static void solve(int l, int r, String curr, List<String> ans){
       if(l == r && l == 0){
          ans.add(curr);
          return;
       }
       if(l > 0) solve(l - 1, r, curr + "(", ans);
       if(l < r) solve(l, r - 1, curr + ")", ans);
    }


}
