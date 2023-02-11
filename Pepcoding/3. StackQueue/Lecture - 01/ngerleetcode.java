import java.util.*;

class Solution {

    //1 2 3 4
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //if not then -1;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums2.length];
        Map<Integer,Integer> map = new HashMap<>();

        //single liner solve for this question baby
        //pretty cool no?
        for(int i = 0; i <= nums2.length ; i++){
            int val = i == nums2.length ? Integer.MAX_VALUE : nums2[i];
            while(!st.isEmpty() && nums2[st.peek()] < val){
                int curr = st.pop();
                ans[curr] = i == nums2.length ? -1 : val;
                map.put(nums2[curr], ans[curr]);
            }
            st.push(i);
        }

        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i= 0; i < nums2.length; i++){
        //     map.put(nums2[i], ans[i]);
        // }

        int[] answer = new int[nums1.length];
        for(int i= 0; i < nums1.length ; i++){
            answer[i] = map.get(nums1[i]);
        }

        return answer;
        
    }
}