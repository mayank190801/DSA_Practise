import java.util.HashMap;
import java.util.*;

public class minWindowSubstring {
    public static void main(String[] args) {
        
    }

    //not a fixed window for this question
    //i -> release
    //j -> expansion

    //MIN WINDOW SUBSTRING
    //simple question
    public String minWindow(String s, String p) {
        HashMap<Character, Integer> pmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();

        int l1 = s.length();
        int l2 = p.length();

        if(l2 > l1) return "";
       
        for(char ch : p.toCharArray()){
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
       
        int count = p.length();
        int ccount = 0;
        int i = 0;
        int j = 0;
        int ans = s.length()+1;
        int st = -1;

        //SIMPLY DIVIDE THE PROBLEM IN TWO PARTS
        //SOLVE EACH PART ON ITS OWN, SIMPLE AS THAT BOI
        while(j < s.length()){
            //expand
            while(j < s.length()){
                char exp = s.charAt(j);
                smap.put(exp, smap.getOrDefault(exp, 0) + 1);
                if(smap.get(exp) <= pmap.getOrDefault(exp, 0)){
                    ccount++;
                }
                j++;
                if(ccount == count){
                    break;
                }
            }

            //release
            while (i < j && count == ccount) {
                if (j - i < ans) {
                    ans = j - i;
                    st = i;
                }

                char rel = s.charAt(i);
                smap.put(rel, smap.get(rel) -1);
                if(smap.get(rel) < pmap.getOrDefault(rel, 0)){
                    ccount--;
                }
                i++;
                if(ccount < count){
                    break;
                }
            }

        }
    
        //simple check for the answer
        return st == -1 ? "" : s.substring(st, st+ans);

    }
    
}
