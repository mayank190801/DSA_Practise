public class queueArray {

    int size = 0;
    int capacity;
    int[] arr;

    //head mein add
    int head = 0;
    //tail se remove
    int tail = -1;

    queueArray(int capacity){
        arr = new int[capacity];
        this.capacity = capacity;
    }

    //add 
    public void add(int val){
        if(size == capacity){
            System.out.println("Queue overflow");
            return;
        }

        arr[head] = val;
        head = (head+1)%capacity;
        size++;
        return;
    }

    //poll
    public int poll(){
        if(size == 0){
            System.out.println("Queue Empty");
            return -1;
        } 

        tail = (tail+1)%capacity;
        int ans = arr[tail];
        size--;
        return ans;
    }

    //peek
    public int peek(){
        if(size == 0) return -1;

        int index = (tail + 1)%capacity;
        return arr[index];
    }
    //size
    public int size(){
        return size;
    }

    //isEmpty
    public boolean isEmpty(){
        return size == 0;
    }

    //display
    //a bit tricky to think about to be honest, but solving on your own is always better
    //you learn and keep it solid in your memory

    //display code my versiono
    // public void display(){
        
    //     int ttail = tail;
    //     int tsize = size;

    //     while(tsize != 0){
    //         ttail = (ttail + 1)%capacity;
    //         System.out.println(arr[ttail]);
    //         tsize--;
    //     }
    //     //done by now
    // }

    //his display code is much much much better than time for sure
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(i + tail+1) % capacity] + " ");
        }
        System.out.println();
    }

}
