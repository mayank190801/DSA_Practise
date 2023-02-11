import java.io.*;
import java.util.*;

public class balanceBrackets{

    public static boolean solve(String str){
        //think of this piece of code for now, and solve this question, once and for all
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length() ; i++){
            char ch = str.charAt(i);

            // System.out.println(ch);
            // System.out.println(stack);
            if(!(ch == '{' || ch == '}' || ch == '(' || ch == ')' || ch == '[' || ch == ']')) continue;

            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }

            if(ch == '{' || ch == '(' || ch == '['){
                stack.push(ch);
            }else{
                if(ch == '}' && stack.peek() != '{') return false;
                if(ch == ')' && stack.peek() != '(') return false;
                if(ch == ']' && stack.peek() != '[') return false;
                stack.pop();
            }
        }
    
        return stack.size() == 0;
    }

    public static void main(String[] args) throws Exception {
        //gotta think about this one
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();
        boolean answer = solve(str);
        
        System.out.println(answer);


    }

}