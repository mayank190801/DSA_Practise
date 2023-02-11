import java.util.*;

public class minWindow2 {
    public static void main(String[] args) {
        
    }

    //MINIMUM WINDOW SUBSTRING 2 (circular string shit)
    //imaginary double string concept is op, whenever there is circual shit question
    //this is something i definitely learned in here, way easy and no space
    //only more time complexity bois
    public String minWindowII(String s, String p) {
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
         int ans = 2*s.length()+1;
         int st = -1;
         int len = 2*s.length();
 
         while(j < len){
             //expand
             while(j < len){
                 char exp = s.charAt(j%l1);
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
 
                 char rel = s.charAt(i%l1);
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
         //fix this bad boi for sure
         if(st == -1) return "";
 
         StringBuilder sb = new StringBuilder();
         while(ans > 0){
             sb.append(s.charAt(st%l1));
             st++;
             ans--;
         }
 
         return st == -1 ? "" : sb.toString();
     }
}
