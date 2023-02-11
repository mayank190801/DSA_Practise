import java.util.*;

public class isomorphic {
    public static void main(String[] args) {
        
    }

    //USING HASHSET AND SET, rather than two hashset, fastest method 
    //out there bbois , hehehehehehehehh
    public boolean isIsomorphic(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        Map<Character, Character> map1 = new HashMap<>();
        Set<Character> set1  = new HashSet<>();
        //could have changed the way shit happen, using hashset for sure
        
        for(int i = 0; i < ss.length ; i++){
            char cs = ss[i];
            char ct = tt[i];

            if(map1.containsKey(cs)){
                if(ct != map1.get(cs)) return false;
            }else{
                if(set1.contains(ct)) return false;
                map1.put(cs, ct);
                set1.add(ct);
            }
    
        }
        
        return true;
    }
}
