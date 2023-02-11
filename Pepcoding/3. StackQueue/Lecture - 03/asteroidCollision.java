import java.util.Stack;

class Solution {

    //sir piece of code should be written with much more importance
    public int[] asteroidCollision(int[] arr) {

        Stack<Integer> st = new Stack<>();
        for(int i= 0; i < arr.length; i++){
            if(st.size() == 0){
                st.push(arr[i]);
            }else{
                int b = arr[i];
                int a = st.peek();
                if(a > 0 && b < 0){//they will collide
                    b = -b;
                    if(a == b){//both will burst
                        st.pop();
                    }else if( a < b ){//only a will burst
                        st.pop();
                        i--;
                    }else{//only b will burst
                        
                    }
                }else{
                    st.push(arr[i]);
                }
            }
        }

        int[] ans = new int[st.size()];
        // for(int i = ans.length -1; i>= 0; i--){
        //     ans[i] = st.pop();
        // }
        int i = ans.length -1;
        while(st.size() > 0){
            ans[i] = st.pop();
            i--;
        }
        
        return ans;
    }


    //my version of code, too long but it works for sure
    //kinda annoying i couldn't solve it during google internship
    //suck too much for sure
    // public int[] asteroidCollision(int[] asteroids) {
    //     //taking it in 
    //     Stack<Integer> stack = new Stack<>();
    //     for(int i= 0; i < asteroids.length; i++){

    //         if(stack.isEmpty()){
    //             stack.push(asteroids[i]);
    //             continue;
    //         }
            
    //         boolean flag = false;
    //         while(!stack.isEmpty() && asteroids[i] < 0){
    //             if(stack.peek() < 0){
    //                 stack.push(asteroids[i]);
    //                 flag = false;
    //                 break;
    //             }else{
    //                 if(stack.peek() > -asteroids[i]){
    //                     flag = false;
    //                     break;
    //                 }else if(stack.peek() == -asteroids[i]){
    //                     stack.pop();
    //                     flag = false;
    //                     break;
    //                 }else if(stack.peek() < -asteroids[i]){
    //                     stack.pop();
    //                     flag = true;
    //                 }
    //             }
    //         }

    //         if(asteroids[i] > 0 || flag){
    //             stack.push(asteroids[i]);
    //         }
    //     }
    
    //     int[] answer = new int[stack.size()];

    //     for(int i= answer.length -1 ; i >= 0; i--){
    //         answer[i] = stack.pop();
    //     }

    //     return answer;
    // }
}