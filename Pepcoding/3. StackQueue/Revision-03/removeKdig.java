import java.io.*;
import java.util.*;

public class removeKdig {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String num = read.readLine();
        int k = Integer.parseInt(read.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < num.length(); i++){
        	int val = num.charAt(i) - '0';
        	if(stack.isEmpty()){
        		stack.push(val);
        	}else{
        		while(!stack.isEmpty() && stack.peek() > val && k > 0){
        			stack.pop();
        			k--;
        		}
        		stack.push(val);
        	}
        }

        //if after this also we have k left!! 
        //simply remove from the end
        while(k--> 0){
        	stack.pop();
        }

        if(stack.isEmpty()){
        	System.out.println("0");
        	return;
        }

        // System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
        	sb.append(stack.pop());
        }

        String ans = sb.reverse().toString();

        //remove any appending zero if possible please

        int idx = 0;
        for(int i = 0; i < ans.length() - 1; i++){
        	if(ans.charAt(i) == '0') idx++; else break;
        }

        ans = ans.substring(idx, ans.length());

        System.out.println(ans);

    }
}





