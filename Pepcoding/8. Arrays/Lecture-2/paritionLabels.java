import java.util.*;

public class paritionLabels {

    //this questions are really pretty cool for sure
    public List<Integer> partitionLabels(String s) {
        char[] inp = s.toCharArray();
        int[] almap = new int[26];

        //now think about this one (for sure) 
        int idx = 0;
        for(char ch : inp){
            almap[ch-'a'] = idx++;
        }
        
        //now mapping is done for sure
        ArrayList<Integer> ans = new ArrayList<>();

        int lastIdx = almap[inp[0] -'a'];
        int last = 0;
        for(int i= 0; i < inp.length; i++){
            char curr = inp[i];
            lastIdx = Math.max(lastIdx, almap[curr-'a']);

            if(i == lastIdx){
                ans.add(lastIdx - last + 1);
                last = lastIdx+1;
            }
        }
        
        return ans;
    }
}
