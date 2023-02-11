package StackUsingQueue;
import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

    //let's make pop efficient for this version
    //and use two queue in this one
    //let's code it as fast as i can, hehehehehhe, i am a monster, for sure

    //this time we will making pop efficient with two queues only

    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();
    
    public MyStack() {
        
    }
    
    //let's implement this one for now
    public void push(int x) {
        while(q1.isEmpty()){
            q2.add(q1.poll());
        }

        q1.add(x);

        while(q2.isEmpty()){
            q1.add(q2.poll());
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    //think for this case for once brother
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
