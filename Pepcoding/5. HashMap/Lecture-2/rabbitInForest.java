import java.util.HashMap;

public class rabbitInForest {

    public static void main(String[] args) {
        
    }

    //for bois 
    //this piece of code works for sure, heheheheh
    //I am happy about this man
    //Could have used array to map this stuff, not a big deal for sure

    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : answers){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        //now simply count them all boi
        int count = 0;
        for(int i : map.keySet()){
            //find a better way to do this below piece of code
            //perfect way lol, didn't use any function hehe`
            int groups = map.get(i)%(i+1) == 0 ? 0 : 1;
            groups += map.get(i)/(i+1);

            count += (i+1)* groups;
        }

        return count;
    }
    
}
