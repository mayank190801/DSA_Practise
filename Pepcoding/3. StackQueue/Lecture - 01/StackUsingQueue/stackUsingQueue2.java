package StackUsingQueue;
import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

    //let's make push efficient for this version
    //and use two queue in this one
    //let's code it as fast as i can, hehehehehhe, i am a monster, for sure

    //this is same as before, but we will use only one queue in this one forreal
    //this works too for sure

    Queue<Integer> q1 = new ArrayDeque<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        for(int i = 0; i < q1.size() - 1 ; i++){
            q1.add(q1.poll());
        }
        
        int answer = q1.poll();
        return answer;
    }
    
    //think for this case for once brother
    public int top() {
        for(int i = 0; i < q1.size() - 1 ; i++){
            q1.add(q1.poll());
        }
        
        int answer = q1.peek();
        q1.add(q1.poll());

        return answer;    
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
