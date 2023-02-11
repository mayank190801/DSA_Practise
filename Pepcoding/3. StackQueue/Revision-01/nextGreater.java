import java.io.*;
import java.util.*;

public class nextGreaterOnRight{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 
 //leetcode should be happening now bruh!!s
 class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int n = nums2.length;
    	int[] ans = new int[n];
    	Stack<Integer> stack = new Stack<>();

    	for(int i = 0; i <= n; i++){
    		int val = i == n ? Integer.MAX_VALUE : nums2[i];
    		while(!stack.isEmpty() && nums2[stack.peek()] < val){
    			int idx = stack.pop();
    			ans[idx] = i == n ? -1 : i;
    		}

    		stack.push(i);
    	}

    	//now for every values in nums2 we would have an answer
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < n; i++){  
    		map.put(nums2[i], ans[i] == -1 ? -1 : nums2[ans[i]]);
    	}

    	//later on make the answer for final shit
    	for(int i= 0; i < nums1.length; i++){
    		nums1[i] = map.get(nums1[i]);
    	}
        
        return nums1;
    }
}








} 