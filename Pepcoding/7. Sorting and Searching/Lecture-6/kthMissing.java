public class kthMissing {

    //FIND KTH USING O(N) //METHOD-1 
    public int findKthPositive(int[] arr, int k) {
        int val = 1;
        int i = 0;
        while(i < arr.length && k!= 0){
            if(arr[i] == val){
                i++;
                val++;
            }else{
                k--;
                val++;
            }
        }
        if(k == 0){
            return val-1;
        }else{
            return val + k -1;
        }
    }
    
}
