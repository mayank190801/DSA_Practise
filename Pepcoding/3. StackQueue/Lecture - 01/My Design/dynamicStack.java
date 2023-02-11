//this is what you have do in the interview if he asks you to implement 
//dynamic stack in your code
//simple as fuck bruh
public class dynamicStack extends stackArray{

    dynamicStack(int capacity){
        super(capacity);
    }

    @Override
    public void push(int val){
        if(super.top+1 == super.capacity){
            int[] temp = super.arr;
            super.arr = new int[temp.length * 2];

            for(int i = 0; i < temp.length ; i++)
                super.arr[i] = temp[i];

            //gotta update capacity
            //important part of the code
            super.capacity = super.arr.length;
        }
          
        super.arr[top+1] = val;
        top++;
    }

}
