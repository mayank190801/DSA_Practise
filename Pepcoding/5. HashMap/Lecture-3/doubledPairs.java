import java.util.Arrays;
import java.util.HashMap;

public class doubledPairs {
    public static void main(String[] args) {
        
    }
    
    //solve this bad boi in here
    //O(nlogn) my easy solve, not much to think about for sure, but it is how it is
    //His way of solving is way too annoying, too hard for the brain to understand for sure
    //not entirely optimised way of solving this question for sure
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr){
            if(ele == 0) return false;
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        Arrays.sort(arr);
        for(int ele : arr){
            if(map.getOrDefault(ele, 0)== 0) continue;
            int cval =  ele < 0 ? (ele/2) : (ele*2);
            //-3 -1 2 4 
            if(ele < 0 && ele%2 != 0) return false;
            if(map.getOrDefault(cval,0) > 0){
                map.put(ele, map.get(ele) -1);
                map.put(cval, map.get(cval) -1);
            }else{
                return false;
            }
        }

        return true;
    }

    //wrong answer, but that girl said it could be right, nope 
    //-4 2
}
