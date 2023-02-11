public class checkAP{
    public static void main(String[] args) {
        
    }
    //method 1 is simple sorting , and checking after that, that would be 
    //pretty easy if you ask me for sure

    //method 2 is basically using set and checking for every position
    //if that certain ele exist or not

    //this is the method 3 for solving this question
    //without space and in O(n);
    
    boolean checkIsAP(int arr[] ,int n)
    {
        // code here
        if(n == 1) return true;
        
        int a = Integer.MAX_VALUE;
        int an = Integer.MIN_VALUE;

        for(int ele : arr){
            an = Math.max(an, ele);
            a = Math.min(a, ele);
        }

        int d = (an - a)/(n-1);
        if((an-a)%(n-1) != 0){
            return false;
        }
        
        if(a == an){
            return true;
        }

        int i = 0;
        while(i < n){
            int idx = ((arr[i] - a)/(d));
            if( ((arr[i] - a)%(d)) != 0){
                return false;
            }

            if(arr[idx] == arr[i]){
                if (i == idx){
                    i++;
                    continue;
                }else{
                    return false;
                }
            }
            swap(arr, i , idx);
        }
        return true;
    }

    public void swap(int[] arr, int i , int j){
        //one line swap for the swap function 
        arr[j] = ((arr[i]+ arr[j])- (arr[i] = arr[j]));
    }
}