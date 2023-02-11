import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//this will be according to sir way for sure,
//let's do this one for sure
//let's see his version for sure
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i= 0; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(!(ch == ')' || ch == '(')) continue;
            if(ch == ')' && s.charAt(stack.peek()) == '('){
                stack.pop();
            }else{
                stack.add(i);
            }
        }
    
        StringBuilder sb = new StringBuilder();
        int i = s.length() -1;
        while(i > -1){
            if(!(!stack.isEmpty() && stack.peek() == i)){
                sb.append(s.charAt(i));
            }
            i--;
        }

        return sb.reverse().toString();
    }
}

//my way of doing things, this is how it looks like
// class Solution {
//     public String minRemoveToMakeValid(String s) {
//         Stack<Integer> stack = new Stack<>();
//         stack.add(-1);

//         for(int i= 0; i < s.length() ; i++){
//             char ch = s.charAt(i);

//             if(!(ch == ')' || ch == '(')) continue;

//             //this is pretty obvious no?
//             if(ch == ')' && stack.peek() != -1 && s.charAt(stack.peek()) == '('){
//                 stack.pop();
//             }else{
//                 stack.add(i);
//             }
//         }

//         Set<Integer> set = new HashSet<>();
//         while(!stack.isEmpty()){
//             set.add(stack.pop());
//         }
//         StringBuilder sb = new StringBuilder();
//         for(int i= 0; i < s.length(); i++){
//             if(set.contains(i)) continue;
//             sb.append(s.charAt(i));
//         }

//         String answer = sb.toString();
//         return answer;
//     }
// }