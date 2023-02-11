public class uglyNumber2 {


    public static void main(String[] args) {
        //one more way of thinking for future pruposes coudld be
        //suppose you wanna take some 
        //make an array, and for every number check something
        //if % 2, 3 5 == 0 then they should have been crossed too!!
        //simply if you come at 7 it ain't possible, hence not added to list
        //try running this code please, i am already on backlog
        //do it future mayank, you would be pretty smart to figure out if it will
        //be correct or not
    
    }

    //first is basic recusion and non inifinite solve bois

    //a number of optimisations could be done along the way
    //this is the last and most optimised one till now
    //first you could make three different linkedlist and keep growing the other ones
    //then you would think,no you don't require three linkedlist , and only two pointers could be doable
    //this is step wise thinking for this question, pretty typical
    //a hard one for sure(but dp and pointers superb question)

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int two = 0;
        int three = 0;
        int five = 0;
        dp[0] = 1;
        for(int i= 1; i < n; i++){
            int twoval = 2 * dp[two];
            int threeval = 3 * dp[three];
            int fiveval = 5 * dp[five];

            int min = Math.min(twoval, Math.min(threeval, fiveval));
            dp[i] = min;

            if(min == threeval) three++;
            if(min == twoval) two++;
            if(min == fiveval) five++;
    
        }
        
        return dp[n-1];
    }

     
    
}
