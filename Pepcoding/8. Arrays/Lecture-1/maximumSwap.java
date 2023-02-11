import java.util.Arrays;

public class maximumSwap {
    //time (O(n * no. of digits))
    //space (O(1))

    //IN THIS QUESTION
    //basically we learned that if we are repeating some similar type of 
    //operation again and again, you can do it once in the start and repeat 
    //it again and again

    //IT FREAKIN WORKED MAN //I am kinda getting brilliant now
    //PRECOMPUTATION TYPE OF QUESTION
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray(); //converting integer to string
        int[] digmap = new int[10];     //not at all extra space
        Arrays.fill(digmap, -1);     //pretty obvious

        //simple as that 
        for(int i= 0; i < arr.length; i++){
            int curr = arr[i]-'0';
            digmap[curr] = i;
        }

        //above shit is simple 
        for(int i = 0; i < arr.length; i++){
            int curr = arr[i] - '0';
            //check for any smaller
            boolean flag = true;
            for(int j = 9; j > curr; j--){
                if(digmap[j] > i){
                    swap(arr, i, digmap[j]);
                    flag = false;
                    break;
                }
            }

            if(!flag) break;
        }

        //new number 
        String curr = String.valueOf(arr);
        int ans = Integer.parseInt(curr);
        return ans;
    }

    //let's swap it all
    public static void swap(char[] inp, int i , int j){
        char temp = inp[i];
        inp[i] = inp[j];
        inp[j] = temp;
    }
    
}
