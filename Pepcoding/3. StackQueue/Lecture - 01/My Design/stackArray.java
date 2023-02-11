public class stackArray {

     int[] arr;
     int capacity;
     int top;
    //for stack i would only need one pointer
    //that would be calle top

    stackArray(int capacity){
        arr = new int[capacity];
        this.capacity = capacity;
        top = -1;
    }

    public void push(int val){
        if(top+1 == capacity){
            System.out.println("Stack overflow");
            return;
        }
        
        arr[top+1] = val;
        top++;
    }

    public int pop(){
        if(top == -1){
            System.out.println("Stack empty");
            return -1;
        } 

        int ans = arr[top];
        top--;
        return ans;
    }
    //size function
    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return top == -1 ? true : false;
    }
    
    public void display(){
        //this.top is compulsory for the interview
        //don't you ever forget it by mistake for sure
        for(int i = 0; i <= this.top ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
