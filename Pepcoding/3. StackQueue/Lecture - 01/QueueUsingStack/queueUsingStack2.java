package QueueUsingStack;
class MyQueue {

    //my original way of solving this problem is this
    //i still remember this method, and i think this one is better than everyone out there

    /** Initialize your data structure here. */
    
    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;
        
    public MyQueue() {
        stackOne = new Stack<Integer>();
        stackTwo = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackOne.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if(stackTwo.isEmpty()){
            while(!stackOne.isEmpty()){
            stackTwo.push(stackOne.pop());
            }
        }
            
        return stackTwo.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(stackTwo.isEmpty()){
            while(!stackOne.isEmpty()){
            stackTwo.push(stackOne.pop());
            }
        }
            
        return stackTwo.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stackOne.isEmpty() && stackTwo.isEmpty()){
            return true;
        }
        
        return false;
    }
}