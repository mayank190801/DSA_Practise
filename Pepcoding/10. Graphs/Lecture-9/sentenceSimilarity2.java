import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sentenceSimilarity2 {

    public static void main(String[] args) {
        //no idea how to check, but this code looks clearner for sure
        //we will try to run it on some test case for now no worries
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};

        List<List<String>> pairs = new ArrayList<>();
        List<String> one = new ArrayList<>();
        one.add("great");
        one.add("good");
        pairs.add(one);

        List<String> two = new ArrayList<>();
        two.add("fine");
        two.add("good");
        pairs.add(two);

        List<String> three = new ArrayList<>();
        three.add("drama");
        three.add("acting");
        pairs.add(three);

        List<String> four = new ArrayList<>();
        four.add("skills");
        four.add("talent");
        pairs.add(four);

        boolean ans = isSentenceSimilarity(words1, words2, pairs);
        System.out.println(ans);
    }
    
    public static int find(int[] par, int u){
        return par[u] == u ? u : (par[u] = find(par, par[u]));  //pretty single line logic
    }

    //given information for sure, try solving this problem for the best of both worlds
    //never say never!

    //DSU with hashmap!! (dope shit bois)
    //giving every string some value bruh! 
    public static boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        //first add all strings from pairs and give them some kind of numbering - my way of solving
        HashMap<String, Integer> map = new HashMap<>();
        for(List<String> pair : pairs){
            for(String curr : pair){
                if(map.containsKey(curr)) continue;
                map.put(curr, map.size());
            }
        }

        //after this we have some numberings attached 
        int n = map.size();
        int[] par = new int[n];
        for(int i= 0; i < n; i++){
            par[i] = i;  //after this it should be resolved for sure!
        }

        //let's make pairing and union right now
        for(List<String> pair : pairs){
            String one = pair.get(0);
            String two = pair.get(1);
            int none = map.get(one);
            int ntwo = map.get(two);

            //after this find their parents
            int p1 = find(par, none);
            int p2 = find(par, ntwo);

            if(p1 != p2){
                par[p1] = p2;
            }
        }

        //now making parent finding simpler
        for(int i= 0; i < words1.length; i++){
            String one = words1[i];
            String two = words2[i];

            if(one.compareTo(two) == 0) continue;  //incase both are same strings, simply move on
            if(!map.containsKey(one) || !map.containsKey(two)){
                return false;
            }
            
            //otherwise simply check if their parents are same or not
            int none = map.get(one);
            int ntwo = map.get(two);
            if(find(par, none) != find(par, ntwo)) return false;
        }
        // write your code here
        return true;
    }
}
