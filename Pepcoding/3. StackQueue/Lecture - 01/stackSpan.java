import java.io.*;
import java.util.*;

public class stackSpan{
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

    //basically same thing, but left greater ka index dhundna hai
    //agar ni hai toh bas simple distance from the index lga dene ka hai
    //simple as taht

    //next greater element on left basically
    Stack<Integer> st = new Stack<>();  
    int[] ans = new int[arr.length];

    for(int i = arr.length -1 ; i >= -1; i--){
        int val = i == -1 ? Integer.MAX_VALUE : arr[i];

        while(!st.isEmpty() && arr[st.peek()] < val){
            int curr = st.pop();
            ans[curr] = i == -1 ? (curr + 1) : curr - i;
        }

        st.push(i);
    }

    return ans;
 }

}