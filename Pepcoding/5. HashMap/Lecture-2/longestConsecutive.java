import java.util.HashMap;

public class longestConsecutive {
    public static void main(String[] args) {
        //pretty dope for sure
        //should give time to think for these types of question for sure
        //This is for sure very very very important mannnnn!!!!
    }

    //let's do this one for sure
    public int longestConsecutive(int[] nums) {
        //easy as fuck in one traversal
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //only update left and right most in single traversal
        //very very very op question for sure
        //only ends are needed to be updated in here
        int ans =0;
        for(int ele : nums){

            if(map.containsKey(ele)) continue;

            Integer left = map.get(ele-1);
            Integer right = map.get(ele + 1);

            if(left != null && right != null){
                int cval = left + right + 1;
                map.put(ele, cval);
                //main updation is of end points
                map.put(ele + right, cval);
                map.put(ele - left, cval);
        
            }else if(left != null){
                int cval = left + 1;
                map.put(ele, cval);
                map.put(ele - left, cval);

            }else if(right != null){
                int cval = right + 1;
                map.put(ele, cval);
                map.put(ele + right, cval);

            }else{
                map.put(ele, 1);
            }

            ans = Math.max(ans, map.get(ele));
        }

        return ans;
    }
   
}
