import java.util.Stack;

class MinStack {

    //this was maxStackQuestion, now we will figure out minstack question
    //which is defintelyty less annoying for sure
    Stack<Integer> st = new Stack<>();
    long min = 0;

    public MinStack() {
        
    }
    
    public void push(int vall) {
        long val = vall
        ;
        if(st.isEmpty()){
            min = val;
            st.push((int)val);
            return;
        }
        
        if(val < min){
            st.push((int)(2*val - min));
            min = val;
        }else{
            st.push((int)val);
        }
    }
    
    public void pop() {
        if(st.peek() < min){//modification
            //change or perfect the min for this question
            min = 2*min - st.peek();
            st.pop();
        }else{
            st.pop();
        }
    }
    
    public int top() {
        if(st.peek() < min){//modifications
            return (int)min;
        }

        return st.peek();
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */