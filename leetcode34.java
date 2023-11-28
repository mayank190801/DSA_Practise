import java.util.List;

public class leetcode34 {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < len; i++){
            int prev = Integer.MAX_VALUE;
            for(int j = 0; j < triangle.get(i).size(); j++){
               int next = j == triangle.get(i).size() - 1 ? Integer.MAX_VALUE : dp[j];
               dp[j] = triangle.get(i).get(j) + Math.min(next, prev);
               prev = next;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i : dp) ans = Math.min(ans, i);
        return ans;
    }





}
