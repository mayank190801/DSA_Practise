import java.util.ArrayList;

public class wordBreak2 {

    public static void main(String[] args) {
        //pretty dope as fuck code for sure!!! (in love with it man!!)
        //gotta revise it for fucking sure again man!!!
    }
    
    //similar to before wordBreak1 by sir method
    public List<String> wordBreak(String s, List<String> wordDict) {
            //Def def def much faster piece of code!!! 
        // remeber this one
        int len = s.length();
        List<String>[] dp = new ArrayList[len];

        HashSet<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }

        for(int i = 0; i < len; i++){
            dp[i] = new ArrayList<>();
            for(int j = i; j >= 0; j--){
                String lastPart = s.substring(j, i+1);
                if(set.contains(lastPart)){
                    if(j == 0){
                        dp[i].add(lastPart);
                    }else{
                        List<String> p = dp[j-1];
                        for(String slastpart : p){
                            dp[i].add(slastpart + " " + lastPart);
                        }
                    }
                }
            }
        }

        return dp[len - 1];
    }
}
