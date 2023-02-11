public class numberUniqueGood {

    //Using previous learned technique (prev questions)
    //dang this code works for sure babyyyyy (the logic for these questions is how many 1 left now
    //how many zero left now!! keep figuring this out at each step & you are good to go)
    public int numberOfUniqueGoodSubsequences(String binary) {
        long zero = 0;
        long mod = 1_000_000_007;
        long one = 0;
        boolean iszp = false;  //not present (one edge case to be taken care of)
        for(char ch : binary.toCharArray()){
            if(ch == '0'){
                zero = (zero + one)%mod;
                iszp = true;
            }else{
                one = (zero + one + 1L)%mod;
            }
        }

        if(iszp) zero++;
        return (int)((zero + one)%mod);
    }

}
