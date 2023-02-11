class MyCircularQueue {

    int head = 0;
    int tail = 0;
    int size = 0;
    int cap = 0;
    int[] arr;
    public MyCircularQueue(int k) {
        arr = new int[k];
        head = 0;
        tail = 0;
        size = 0;
        cap = k;
    }
    
    public boolean enQueue(int value) {
        if(size == cap){
            return false;
        }

        arr[head%cap] = value;
        head++;
        size++;

        return true;
    }
    
    public boolean deQueue() {
        if(size == 0){
            return false;
        }

        tail++;
        size--;
        return true;
    }
    
    public int Front() {
        if(size == 0) return -1;
        return arr[tail%cap];     
    }
    
    public int Rear() {
        if(size == 0) return -1;
        return arr[(head - 1)%cap];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */