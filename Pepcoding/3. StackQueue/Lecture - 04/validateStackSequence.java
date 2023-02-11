import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;

        Stack<Integer> st = new Stack<>();
        while(i != pushed.length && j != popped.length){

            st.add(pushed[i]);
            i++;

            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }
           
        return i == pushed.length && j == popped.length;
    }
}
