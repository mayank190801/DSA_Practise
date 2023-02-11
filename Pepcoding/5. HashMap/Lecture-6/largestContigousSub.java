import java.util.HashSet;

public class largestContigousSub {
    public static void main(String[] args) {
        
    }

    //think about it for now bois
    //duplicate and  non duplicate
    //if duplicate present, then just break boi, simple as that for sure

    //LARGEST CONTIGOUS SUBARRAY 2
    //simple question, with max and min concept, i didn't know about disticts 
    //get clear with your concepts bois, read question properly
    public int largestSubarray(int[] arr){
        int ans = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int i=  0; i < arr.length; i++){
            set = new HashSet<>();
            int min = arr[i];
            int max = arr[i];
            for(int j=  i; j< arr.length;j ++){
                if(set.contains(arr[j])) break;
                min = Math.min(arr[j], min);
                max = Math.max(max, arr[j]);

                if(max - min == j-i){
                    ans = Math.max(ans, j-i+1);
                }
                set.add(arr[i]);
            }
        }
        
        return ans;
    }


    
}
