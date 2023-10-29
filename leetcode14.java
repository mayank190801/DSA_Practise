import java.util.*;

public class leetcode14 {
    public static void main(String[] args) {

    }

    //so now we have to move on with this brother - leetcode day in day out - no excuses + gym day in day out no excuses brother
//    public static int maximizeTheProfit(int n, List<List<Integer>> offers) {
//        //make a list<integer> map?? - maybe that could work, idk
//        Map<Integer, List<List<Integer>>> map = new HashMap<>();
//        for(int i = 0; i < offers.size(); i++){
//            int start = offers.get(i).get(0);
//            map.putIfAbsent(start, new ArrayList<>());
//            map.get(start).add(offers.get(i));
//        }
//
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        return solve(n, map, 0, dp);
//    }
//
//    public static int solve(int n, Map<Integer, List<List<Integer>>> map, int curr, int[] dp){
//        if(curr == n) return 0;
//        if(dp[curr] != -1) return dp[curr];
//        int maxAns = solve(n, map, curr + 1, dp);;
//        if(map.containsKey(curr)){
//            List<List<Integer>> starters = map.get(curr);
//            for(int i = 0; i < starters.size(); i++){
//                List<Integer> buyer = starters.get(i);
//                maxAns = Math.max(maxAns, buyer.get(2) + solve(n, map, buyer.get(1) + 1, dp));
//            }
//        }
//        return dp[curr] = maxAns;
//    }

    public static int maximizeTheProfit(int n, List<List<Integer>> offers) {
        //this map part is taking a lot more space - can I reduce it anyhow????
        //memory is extreme high right now - think harder brother - find a even better solution maybe???
        //think think think
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for(int i = 0; i < offers.size(); i++){
            int start = offers.get(i).get(0);
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(offers.get(i));
        }

        int[] dp = new int[n + 1];
        //now just solve the question with dp - no matter - simply become a beast
        for(int i = n - 1; i >= 0; i--){
            if(i + 1 < n) dp[i] = dp[i + 1];
            if(map.containsKey(i)){
                List<List<Integer>> starters = map.get(i);
                for(int j = 0; j < starters.size(); j++){
                    List<Integer> buyer = starters.get(j);
                    dp[i] = Math.max(dp[i], buyer.get(2) + dp[buyer.get(1) + 1]);
                }
            }
        }

        return dp[0];
    }
}




















