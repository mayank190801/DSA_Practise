import java.util.Stack;

class Solution {

    //sir way of doing things, pretty cool
    //this shit is using the latest version of 
    public int minAddToMakeValid(String s) {
        int o = 0;
        int c = 0;

        //for having remaing and shit,not a big deal for sure
        for(int i= 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                o++;
            }else{
                if(o>0){
                    o--;
                }else{
                    c++;
                }
            }
        }

        return o + c;
    } 

    public int minAddToMakeValid(String s) {

        Stack<Character> stack= new Stack<>();
        for(char ch : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }

            if(ch == '('){
                stack.push(ch);
            }else{
                if(stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }

        System.out.println(stack);
        return stack.size();
    }
}