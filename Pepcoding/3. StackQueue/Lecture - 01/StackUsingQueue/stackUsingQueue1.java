package StackUsingQueue;
import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

    //let's make push efficient for this version
    //and use two queue in this one
    //let's code it as fast as i can, hehehehehhe, i am a monster, for sure

    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();
    
    public MyStack() {
        
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        int answer = q1.poll();
        var temp = q1;

        q1 = q2;
        q2 = temp;

        return answer;
    }
    
    //think for this case for once brother
    public int top() {
        
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        int answer = q1.peek();
        q2.add(q1.poll());

        var temp = q1;
        q1 = q2;
        q2 = temp;

        return answer;    
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
