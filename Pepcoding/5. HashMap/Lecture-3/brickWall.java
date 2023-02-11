import java.util.*;

public class brickWall {
    public static void main(String[] args) {
        
    }

    //easy as fuck boi, not hard at all for sure, anyone could solve it
    //hashmap was so so so important for sure in this question
    public int leastBricks(List<List<Integer>> wall) {
        int brakes = 0;
        //could use array rather than hashmap for sure
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < wall.size(); i++){
            int cbrake = 0;
            for(int j = 0; j < wall.get(i).size()-1; j++){
                cbrake += wall.get(i).get(j);
                map.put(cbrake, map.getOrDefault(cbrake, 0)+1);
            }
        }

        for(int i : map.keySet()){
            brakes = Math.max(brakes, map.get(i));
        }
        return wall.size() - brakes;
    }
    
}
