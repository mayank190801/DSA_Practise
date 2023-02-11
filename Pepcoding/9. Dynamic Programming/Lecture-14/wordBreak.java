import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
    public static void main(String[] args) {
        
        String s = "ab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("b");

        boolean check = wordBreak(s, wordDict);
        System.out.println(check);

        //Logic is a bit different
        //I thought of using simple MCM , and boom using iterative approach it was solvable
        
        //Sir is using Single dp to store true false, as well as all the answer till that point
        //that is pretty dope technique too as it gives the answer!!!

    }

    //SIR SOLVE FOR SURE!!!! (let's figure that one out)
    //DOPE SUTFF IS THERE FOR SUREE!!! (use it whenever you want)
    public static boolean wordBreak(String s, List<String> wordDict) {
        //Def def def much faster piece of code!!! 
        // remeber this one

        int len = s.length();
        boolean[] dp = new boolean[len];

        HashSet<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }

        for(int i = 0; i < len; i++){
            for(int j = i; j >= 0; j--){
                String lastPart = s.substring(j, i+1);
                if(set.contains(lastPart)){
                    if(j == 0 || dp[j-1] == true){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[len - 1];
    }


    //MY SOLVE
    //Word break iterative MCM my solve, for sure!!!
    //This was perfect boi!!! (supremeness of perfection for sure)
    //Definitely loved this part of the question for sure
    public static boolean wordBreak(String s, List<String> wordDict) {

        //put wordDict in hashMap for this question
        Set<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }

        //make dp to store answer 
        int N = s.length();
        int[][] dp = new int[N+1][N+1];

        for(int gap = 0; gap < N; gap++){  //space in between

            int x = 0;
            int y = gap;

            while(y < N){

                String curr = s.substring(x, y+1);
                // System.out.println(curr);
                if(set.contains(curr)){
                    dp[x][y] = 1;
                }

                //otherwise go from left to right
                for(int cut = x; cut <= y; cut++){
                    int left = dp[x][cut];
                    int right = dp[cut + 1][y];

                    if(left == 1 && right == 1){
                        dp[x][y] = 1;
                        break;
                    }
                }

                x++;
                y++;
            } 
        }

       

        return dp[0][N-1] == 1 ? true : false;
    }

    
}
