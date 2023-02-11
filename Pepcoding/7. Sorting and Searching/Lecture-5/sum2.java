import java.util.HashMap;

public class sum2{
    public static void main(String[] args) {
        
    }

    //Method-1
    //O(n2) - O(1)-> Go on one element and try to find the another element

    //Method-2
    //O(nlogn) - O(1)-> Sort the array, put on one, find through binary search

    //below two are important

    //Method-3 (BEST OPTMISED) 
    //O(n) - O(n) -> Using hashmap in single traversal (append once visited)

    //Method-4 (MOST IMPORTANT) //teaches a lot boi 
    //O(nlogn + n) - O(1) -> Using sorting and 2 pointers

    //2 SUM

    //O(nlogn + n)
    public int[] twoSum(int[] nums, int target) {

        //Pretty clear obviously boi
        int[][] mix = new int[nums.length][2];
        for(int i= 0; i < nums.length; i++){
            mix[i][0] = nums[i];
            mix[i][1] =i;
        }

        Arrays.sort(mix, (a,b)->Integer.compare(a[0], b[0]));
        int si = 0;
        int ei = nums.length-1;

        while(si <= ei){
            int sum = mix[si][0] + mix[ei][0];
            if(sum == target){
                return new int[]{mix[si][1],mix[ei][1]};
            }else if(sum < target){
                si++;
            }else{
                ei--;
            }
        }

        return null;
    }

    //O(n) - Using hashmap
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i= 0; i < nums.length; i++){
            //simple sober stuff for sure 
            int value = nums[i];
            if(map.containsKey(target-value)){
                return new int[]{map.get(target-value), i};
            }
            map.put(value, i);
        }
        
        return null;
    }


}