import java.util.HashMap;
import java.util.Map;

public class todo {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) <= 1) return false;
        }
        return true;
    }

}
