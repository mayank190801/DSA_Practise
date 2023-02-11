package StackUsingQueue;
import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

    //let's make pop efficient for this version
    //and use two queue in this one
    //let's code it as fast as i can, hehehehehhe, i am a monster, for sure

    //this time we will making pop efficient with two queues only
    //this time again only using one queue for this whole thing babyyyyyy
    //fuck the complexity to be honest, and just solve it first of all

    Queue<Integer> q1 = new ArrayDeque<>();
    
    public MyStack() {
        
    }
    
    //let's implement this one for now
    public void push(int x) {
        q1.add(x);
        
        //much better way of doing things for sure
        for(int i=0 ; i < q1.size()-1; i++){
            q1.add(q1.poll());    
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
