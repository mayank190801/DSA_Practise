import java.util.Arrays;
import java.util.Stack;

class slidingWindowMax {

    //next greater element with index
    //this question might not get accepted, so let's move on 
    public int[] ngerIdx(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);

        for(int i = 0; i <= arr.length; i++){
            int val = i== arr.length ? Integer.MAX_VALUE : arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] < val){
                int curr = stack.pop();
                ans[curr] = i;
            }

            stack.push(i);
        }

        return ans;
    } 


    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];
        int[] nger = ngerIdx(nums);

        //now think of solving this question
        //this piece of code is what i have to think
        for(int i = 0; i < ans.length ; i++){
            int j = i;
            while (nger[j] < i + k) {
                j = nger[j];
            }
            ans[i] = nums[j];
        }

        return ans;
    }
}