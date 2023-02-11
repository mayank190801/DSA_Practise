import java.io.*;
import java.util.*;

public class largestHisto{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    //solving one traversal is all the deal baby!! 
    Stack<Integer> stack = new Stack<>();
    int fans = 0;

    for(int i= 0; i <= n; i++){
    	int val = i == n ? Integer.MIN_VALUE : a[i];

    	while(!stack.isEmpty() && a[stack.peek()] > val){
    		int nserIdx = i;
    		int height = a[stack.pop()];
    		while(!stack.isEmpty() && height == a[stack.peek()]) stack.pop();
    		int nselIdx = stack.isEmpty() ? -1 : stack.peek();

    		int area = height * (nserIdx - nselIdx - 1);
    		fans = Math.max(fans, area);
    	}

    	stack.push(i);
    }

    System.out.println(fans);
 }
}