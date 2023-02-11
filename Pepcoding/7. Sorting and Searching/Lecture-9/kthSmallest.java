public class kthSmallest {
    public static void main(String[] args) {
        
    }

    //let's try solving this bad boi
    //WHAT A FUCKING QUESTION MAN
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double si = 0.0;
        double ei = 1;


        int[] ans = new int[2];
        while(true){
            double mid = (si + (ei-si)/2);
            int count = 0;

            //count function in here only
            double maxFrac = 0.0;
            double cFrac = 0.0;
            int j = 1;
            for(int i= 0; i < arr.length; i++){
                while(j < arr.length && (arr[i]*1.0) > (mid*arr[j])){
                    j++;
                }
                if(j == arr.length){
                    break;
                }
                //i num
                //j denom
                count += (arr.length-j); //brilliant way of counting stuff
                if(maxFrac*arr[j] < arr[i]*1.0){
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                    maxFrac = (double)arr[i]/(double)arr[j];
                }
            }

            //when you are sure you will get the answer back
            if(count == k){
                return ans;
            }else if(count < k){
                si = mid; //brilliant 
            }else{
                ei = mid; //wow
            }
        }

    }

}
