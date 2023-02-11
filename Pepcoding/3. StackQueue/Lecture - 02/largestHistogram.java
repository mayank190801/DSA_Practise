import java.io.*;
import java.util.*;

public class Main{
public static void main(String[] args) throws Exception {
    //a lot of people use this to take input and shit,
    //you can consider using it at some point for sure
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    // code
    //both side find the element smaller 
    //on left as well as right
    //everyone have their way of doing things, so do that, and move forward
    Stack<Integer> stack = new Stack<>();

    int max = 0;
    for(int i=  0; i <= a.length ; i++){
        int val = i == a.length ? Integer.MIN_VALUE : a[i];

        while(!stack.isEmpty() && a[stack.peek()] > val){
            int curr = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            int rightIndex = i;

            int area = a[curr] * (rightIndex - leftIndex-1);
            max = Math.max(area, max);
        }

        stack.push(i);
    }


    System.out.println(max);

 }
}