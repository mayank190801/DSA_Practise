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

 //nger
 public static int[] nger(int[] arr){
 	Stack<Integer> stack = new Stack<>();
 	int n = arr.length;
 	int[] ans = new int[n];

 	for(int i = n-1; i >= 0; i--){
 		int cval = arr[i];
 		while(!stack.isEmpty()){
 			if(stack.peek() <= cval){
 				stack.pop();
 			}else break;
 		}

 		ans[i] = stack.isEmpty() ? -1 : stack.peek();
 		stack.push(arr[i]);
 	}
  		
   return ans;
 }









} 