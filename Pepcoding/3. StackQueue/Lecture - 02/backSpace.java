import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        //let's think of this for a second now
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '#' && !st1.isEmpty()) st1.pop();
            if(ch != '#') st1.add(ch);
        }

        for(char ch : t.toCharArray()){
            if(ch == '#' && !st2.isEmpty()) st2.pop();
            if(ch != '#') st2.add(ch);
        }

        //now we will compare
        while(!st1.isEmpty() && !st2.isEmpty()){
            if(st1.pop() != st2.pop()) return false;
        }

        return st1.size() == st2.size();
    }
}