import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode1282 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();


        int n = groupSizes.length;
        for(int i = 0; i < n; i++){
            int size = groupSizes[i];
            map.putIfAbsent(size, new ArrayList<>());
            map.get(size).add(i);

            if(map.get(size).size() == size){
                ans.add(map.get(size));
                map.remove(size);
            }
        }

        return ans;
    }


}
