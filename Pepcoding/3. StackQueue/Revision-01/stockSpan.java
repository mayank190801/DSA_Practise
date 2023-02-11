import java.io.*;
import java.util.*;

public class Main{
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

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
  int n = arr.length;
  int[] ans = new int[n];
  Stack<Integer> stack = new Stack<>();

  for(int i = n-1; i >= -1; i--){
    int val = i == -1 ? Integer.MAX_VALUE : arr[i];
    while(!stack.isEmpty() && arr[stack.peek()] < val){
      int idx = stack.pop();
      ans[idx] = i;
    }

    stack.push(i);
  }

  //now make the answer smart
  for(int i= 0; i < n; i++){
    ans[i] = Math.abs(ans[i] - i);
  }

   return ans;
 }

}