import java.util.HashMap;

public class deckOfCards {

    //two method

    //method 1 - wrong, take min and check modulus
    //method 2 - correct, take gcd directly for this answer

    //think about this one for now
    //this one works for sure, hehehehe
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : deck){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        
        int gcd = map.get(deck[0]);
        for(int ele : map.keySet()){
            gcd = gcd(gcd, map.get(ele));
        }

        return gcd >= 2;
    }

    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
    
}
