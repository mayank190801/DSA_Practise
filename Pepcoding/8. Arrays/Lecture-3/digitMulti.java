public class digitMulti {

    //THIS LOGIC IS BEAUTIFUL FOR SURE, A LOTTA BEAUTIFUL
    static String getSmallest(Long N) {
        
        if(N == 1) return "1";
        StringBuilder sb = new StringBuilder();
        for(long i = 9 ; i >= 2; i--){
            while(N%i == 0){
                sb.append(i);
                N = N/i;
            }
        }

        if(N != 1) return "-1";
        String ans = sb.reverse().toString();
        return ans;
    }
    
}
