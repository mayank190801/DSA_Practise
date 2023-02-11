public class consecutiveNumberSum{

    //METHOD - 1 (Simple add and remove element tills O(n));
    //METHOD - 2 ((x+1) + (x+2) ... (x+k) == n)  //this observation
    
    //where for every diff k , there will be a diff x!!!!!
    //if it's integral we get the answer
    //changing the above equation can do wonders in this question


    //THE LOGIC IS MIND BOGGLING FOR THIS QUESTION FOR SURE
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int k= 1;
        
        while(true){
            int diff = n - ((k*(k+1))/2);
            if(diff < 0) break;

            if(diff%k == 0) count++;
            k++;
        }

        return count;
        
    }
}