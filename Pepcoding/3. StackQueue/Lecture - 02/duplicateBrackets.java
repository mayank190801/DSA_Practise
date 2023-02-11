import java.io.*;
import java.util.*;

public class duplicateBrackets{

    public static boolean helper(String str){
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch != ')') stack.push(ch);
            else{
                if(stack.peek() == '(') return false;
                while(stack.peek() != '('){
                    stack.pop();
                }
                stack.pop();
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        //now we have to find duplicate brackets and shit, and figure that out
        //as fast as i can
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        boolean answer = helper(str);
        System.out.println(answer);
    }

}