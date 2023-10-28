import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode6 {

    public static void main(String[] args) {

    }

    //a function to return hamming distance is must needed
    public static boolean hammingDistancePossible(String a, String b){
        if(a.length() != b.length()) return false;
        int cnt = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt == 1;
    }

    public static List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        //we need two arrays for creating our answer and one variable
        int bestLenIndex = -1;
        int bestLenOverall = 0;
        int[] bestIndex = new int[n];
        int[] bestLen = new int[n];
        Arrays.fill(bestIndex, -1);

        for(int i = n - 1; i >= 0; i--){
            int currBestIndex = -1;
            int currBestLen = 0;
            for(int j = i + 1; j < n; j++){
               //first few checks are important at this stage according to me - that's what I think
               if(groups[i] == groups[j]) continue;
               if(!hammingDistancePossible(words[i], words[j])) continue;

               //otherwise a good match for sure
                if(bestLen[j] > currBestLen){
                   currBestLen = bestLen[j];
                   currBestIndex = j;
                }
            }

            //after this all is done
            bestIndex[i] = currBestIndex;
            bestLen[i] = currBestLen + 1;

            if(bestLenOverall < bestLen[i]){
                bestLenOverall = bestLen[i];
                bestLenIndex = i;
            }
        }

//        System.out.println(bestLenIndex);
//        System.out.println(bestLenOverall);
//        System.out.println(Arrays.toString(bestIndex));
//        System.out.println(Arrays.toString(bestLen));

        List<String> ans = new ArrayList<>();
        ans.add(words[bestLenIndex]);
        while(true){
            int next = bestIndex[bestLenIndex];
            if(next == -1) return ans;
            ans.add(words[next]);
            bestLenIndex = next;
        }
    }
}
