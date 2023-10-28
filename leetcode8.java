import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode8 {
    public static void main(String[] args) {

    }

    //let's code our solution from here
    //even on codeforces this is 2000 rated problem - incase of no O(n^2) solution, IDK think about
    //2D a bit more, if you would have known 2D dp, maybe you would have solved it no?

    //let's solve recursive first
    //really high level of intuition is needed to solve this question for sure
    //if you know you know brother - hmm
    //I will see if I encounter a problem similar to this in future, really waiting to see that
    public static int minOperations(String s1, String s2, int x) {
        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) indexes.add(i);
        }
        if(indexes.size() % 2 != 0) return -1;

        //otherwise get your army ready for the fight
        int sz = indexes.size();
        int[] dp = new int[sz];
        Arrays.fill(dp, -1);

        return solve(indexes, 0, dp, x)/2;
    }

    //this where we will right out recursive solution for this problme
    public static int solve(List<Integer> index, int curr, int[] dp, int x){
        if(curr == index.size()) return 0;
        if(curr == index.size() - 1) return x;

        if(dp[curr] != -1) return dp[curr];
        dp[curr] = Math.min(solve(index, curr + 2, dp, x) + (index.get(curr + 1) - index.get(curr))*2, solve(index, curr + 1, dp, x) + x);
        return dp[curr];
    }

}
