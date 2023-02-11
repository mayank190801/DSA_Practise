package QueueUsingStack;
import java.util.Stack;

class MyQueue {

    //pop efficient function for this code
    //let's see how it goes
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        //directly push in the 
        s1.push(x);
    }
    
    public int pop() {
 
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        int answer = s2.pop();

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

        return answer;
    }
    
    public int peek() {

        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        int answer = s2.peek();

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

        return answer;
        
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**