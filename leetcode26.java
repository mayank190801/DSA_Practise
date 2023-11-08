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


    //one more better approach is there to solve this question for once and for all -
    //divide and conquery, how can we do that??? - I have heard this approach a lot
    //think on your own brother, and try to improve it on your own 
}
