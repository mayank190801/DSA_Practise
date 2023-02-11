import java.util.*;

public class anagramMapping{
    public static void main(String[] args) {
        
    }

    //method 1 
    //All substrings of length -> P
    //Check if it is anagaram with another string

    //method 2
    //SIMPLE METHOD FOR SURE
    //fixed window 
    //window of size -'m'
    //counter system to be used for this question

    //WAY FOR FIXED WINDOW TRAVEL
    //#travel fixed size first of all
    //#check answer
    //#then perform general work for the rest of the question
    //-> include, exclude, check for the answer

    //using method 2
    //BRILLIANT WAY OF WRITING THIS CODE FOR SURE
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> pmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();

        int l1 = s.length();
        int l2 = p.length();

        if(l2 > l1) return new ArrayList<>();

        for(char ch : p.toCharArray()){
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
        int count = p.length();
        int ccount = 0;

        //travel for fixed length first
        for(int i = 0;i < l2; i++){
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            if(smap.get(ch) <= pmap.getOrDefault(ch, 0)){
                ccount++;
            }
        }

        //check for fixed length first
        List<Integer> ans = new ArrayList<>();
        if(count == ccount){
            ans.add(0);
        }

        int i= p.length();
        int j= 0;

        //our general task for everyone boi
        //let's solve this bad boi for today man!!
        while(i < s.length()){
            //include
            char inc = s.charAt(i);
            smap.put(inc, smap.getOrDefault(inc, 0) + 1);
            //think for this bad boi, pretty simple
            if(smap.get(inc) <= pmap.getOrDefault(inc, 0)){
                ccount++;
            }

            //exclude
            char exc = s.charAt(j);
            smap.put(exc, smap.get(exc) - 1);
            //think for this case
            //pretty obvious
            if(smap.get(exc) < pmap.getOrDefault(exc, 0)){
                ccount--;
            }

            if(ccount == count){
                ans.add(j+1);
            }

            i++;
            j++;
        }

        return ans;
    }
}