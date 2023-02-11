import java.util.Stack;

class Solution {

    //very basic code for sure
    //but you should have knowledge of solving these one for sure
    //while loop or for loop, that is totally according to your mood
    //not a hard thing to do
    public String removeKdigits(String num, int k) {
     
        //some edge cases are definitely there, but we will ignore them for now
        //this question was stupid as fuck
        Stack<Character> st = new Stack<>();
        for(int i= 0; i < num.length(); i++){
            char ch = num.charAt(i);
            if(st.size() == 0){
                st.push(ch);
            }else{
                //simple logic up here
                if(ch < st.peek() && k > 0){//pop from the stack
                    st.pop();
                    k--;
                    i--;
                }else{
                    st.push(ch);
                }
            }
        }

        //simply remove from the end, as simple as that
        while(k > 0){
            st.pop();
            k--;
        }

        //method in sir mind should be coded only
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        int i = ans.length() -1;
        while(i >= 0 && ans.charAt(i) == '0'){
            i--;
        }

        if(i == -1) return "0";
        
        int len = ans.length();
        return ans.reverse().toString().substring(len-i-1);

    }
}