import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        //simply put in the stack with their indices and keep removing whenver you want bitch
        Stack<Character> stc = new Stack<>();
        Stack<Integer> sti = new Stack<>(); 

        for(int i=  0; i < s.length() ; i++){
            char ch = s.charAt(0);

            if(stc.isEmpty()){
                stc.push(ch);
                sti.push(i);
                continue;
            }

            if(ch == '('){
                stc.push(ch);
                sti.push(i);
                continue;
            }else{
                if(stc.peek() == ')'){
                    stc.pop();
                    sti.pop();
                }else{
                    stc.push(ch);
                    sti.push(i);
                }
            }
        }

        System.out.println(stc);
        System.out.println(sti);

        //now comparing largest using sti and shit
        //everytime 
        int last = s.length()-1;
        int max = 0;
        while(!sti.isEmpty()){
            int curr = sti.pop();
            int diff = last - curr;
            last = curr;
            max = Math.max(max, diff);
        }

        max = Math.max(max, last-0);

        return max;

    }
}