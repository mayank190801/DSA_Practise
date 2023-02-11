public class dynamicQueue extends queueArray{
    
    dynamicQueue(int capacity){
        super(capacity);
    }

    @Override
    public void add(int val){
        
        //this is brilliant for sure, as far as i know, this should work beautifully
        if(super.size == super.capacity){
            //double the length, put all elements in there and change the location of super.head and super.tail
            int[] temp = super.arr;
            super.arr = new int[temp.length*2];

            for(int i = 0; i < super.size ; i++){
                super.arr[i] = temp[(i+super.tail+1)%super.capacity];
            }

            super.tail = -1;
            super.head = super.size;
            super.capacity = super.arr.length;
        }

        super.arr[super.head] = val;
        super.head = (super.head+1)%super.capacity;
        super.size++;
        return;
    }

}
