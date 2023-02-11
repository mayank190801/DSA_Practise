import java.util.Stack;

class Sol{
    int countRev(String s){
        int ans = 0;
        //no need of stack is required either
        //using open close, you could solve it much faster with much less code
        int open = 0;
        int close = 0;

        //shortcut way of doing bracket balance without much efforst
        //this open and close are the keys to the very question
        for(char ch : s.toCharArray()){
            if(ch == '{'){
                open++;
            }else{
                if(open > 0){
                    open--;
                }else{
                    close++;
                }
            }
        }

        if((open + close)%2 != 0) return -1;
        ans = ans + (open/2) + (close/2);
        if(open%2 != 0){
            ans++;
        }

        if(close%2 != 0){
            ans++;
        }

        // ans = (int)Math.ceil(open/2) + (int)Math.ceil(close/2);
        return ans;
    }
}

//my version of code still in progress tho,
//sir uses brain, and reduces the code, this is what i should
//also focus on

// class Sol
// {
//     int countRev (String s)
//     {
//         char[] inp = s.toCharArray();
//         Stack<Character> st = new Stack<>();

//         for(char ch : inp){

//             if(st.isEmpty()){
//                 st.push(ch);
//                 continue;
//             }

//             if(ch == '{'){
//                 st.push(ch);
//             }else{
//                 if(st.peek() == '}'){
//                     st.push(ch);
//                 }else{
//                     st.pop();
//                 }
//             }
//         }

//         System.out.println(st);
//         if(st.size() % 2 == 1){
//             return -1;
//         }

//         //just count left

//     }
// }