import java.util.Stack;

class leetcode2390 {

    public static void main(String[] args) {
        String ans = removeStars("leet**cod*e");
        System.out.println(ans);
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '*'){
                stack.pop();
            }else stack.push(ch);
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }

}