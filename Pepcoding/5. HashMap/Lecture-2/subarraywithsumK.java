import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class subarraywithsumK{

    public static void main(String[] args) {
        //we will be attempting this question in three ways to tbh
        //printing count
        //print subarrays st, end
        //printing max length of the subarray
        

        //you can the run second version of the code in here, for your ease only
        //this will help you a lot for sure
    }

    //method - 1
    //finding all the subarrays one by one and comparing one by one -> O(n^2)

    //count method
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int count = 0;
        int sum = 0;

        for(int i= 0;i < nums.length; i++){
            sum += nums[i];
            //use this 
            // if(map.containsKey(sum - k)){
            //     count += map.get(sum - k);
            // }
            count += map.getOrDefault(sum-k, 0);

            // map.putIfAbsent(sum, 0);j
            // map.put(sum, map.get(sum) + 1);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    //all indices please
    //part 2 of this question
    public List<List<Integer>> subarraySum01(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        
        int sum = 0;

        List<List<Integer>> answer = new ArrayList<>();
        for(int i= 0; i < nums.length; i++){
            sum += nums[i];
            //search if present then solve it one go
            //get or default is legendary 
            List<Integer> list = map.get(sum - k);

            //you can remove these checks as much as you can for sure
            //using inbuilt functions at their best for sure
            if(list != null){
                for(int st : list){
                    //this as list function is pretty coool for sure
                    //always remember this, very efficient for sure
                    //convert array into list and then add to the answer
                    answer.add(Arrays.asList(st+1, i));
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return answer;
    }

    //longest is the easiest for sure bitches
    //LONGEST LENGTH OF ALL 
    //just take the first index and save it in answer

    //some error in this code, think about it for once for sure
    public List<Integer> subarraySum02(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);

        //this is sir way of doing, i would have preffered only one variable for sure
        //blah, let him do whatever he wants
        List<Integer> ans = new ArrayList<>();
        int len = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            //for finding the maximum one
            if(map.containsKey(sum-k) && i - map.get(sum-k) > len){
                len = i - map.get(sum-k);
                ans = Arrays.asList(map.get(sum-k)+1, i);
            }

            //only when it is not present in the game for sure
            //error is fixed for sure now, no one could find this error lol
            //not even me, idiot me lol
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return ans;
    }

}