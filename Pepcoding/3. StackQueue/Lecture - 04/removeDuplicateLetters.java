import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    //let's solve it 
    public String removeDuplicateLetters(String s) {
        int[] vis = new int[26];
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> freq = new HashMap<>();

        //let's first make the freq map so that we could use it later on
        for(char ch : s.toCharArray()){
            freq.putIfAbsent(ch, 0);
            freq.put(ch, freq.get(ch) + 1);
        }

        //now we have done this for now, let's solve it for sure
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            freq.put(curr, freq.get(curr) -1);
            
            if(vis[curr-'a'] == 1) continue;

            while(!stack.isEmpty() && stack.peek() > curr && freq.get(stack.peek()) > 0){
                vis[stack.peek()-'a'] = 0;
                stack.pop(); 
            }

            stack.push(curr);
            vis[curr-'a'] = 1;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}