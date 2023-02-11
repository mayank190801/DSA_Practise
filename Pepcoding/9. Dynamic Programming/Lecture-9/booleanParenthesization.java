import java.util.Arrays;

public class booleanParenthesization {
    
    //FOR SOLVING USING ONLY DP
    //make two 2D dp, one for true and one for counting false
    //dp travelling is same like before si ei
    //gap method to be used in this dp question, pretty annoying but def 
    //should know how to sovle this in this specific way

    //SIR WAY OF RIGHTING THIS CODE BOIS!!!!!
    public static int booleanParan(char[] exp, char[] sym){
        int[] ans = booleanParan(exp, sym, 0, exp.length-1);
        int[][][] dp =new int[exp.length][exp.length][2];
        return ans[0];
    }

    public static int[] booleanParan(char[] exp, char[] sym, int si , int ei, int[][][] dp){

        if(si == ei){
            //brilliant piece of code for sure man!!!! (impressive for real)
            return exp[si] == 'T' ? new int[]{1,0} : new int[]{0,1};
        }

        //dp and modulo needs to be updates only (simple as that)
        //simple as fuck boi
        if(dp[si][ei][0] != 0){
            return dp[si][ei];
        }

        int[] ans = new int[2];

        for(int p = si; p < ei; p++){
            int[] left = booleanParan(exp, sym, si, p, dp);
            int[] right = booleanParan(exp, sym, p+1, ei, dp);

            char csym = sym[p]; //p dependent bro!!
            int lt = left[0];
            int lf = left[1];
            int rt = right[0];
            int rf = right[1];

            if(csym == '&'){
                ans[0] +=  lt*rt;
                ans[1] += lt*rf + lf*rt + lf*rf;
            }else if(csym == '|'){

                //and so on

            }else{
                //and so one

            }

        }

        dp[si][ei][0] = ans[0];
        dp[si][ei][1] = ans[1];
        return ans;
    }



    //let's try solve it no??
    public static void main(String[] args) {
        boolean[] exp = {true, true, false, true};  //input from this side
        char[] sym = { '|', '&', '^'};              //input from operand side
        
        int[] ans = solve(0, sym.length-1, sym, exp);
        System.out.println(Arrays.toString(ans));

        //this code is working bitch
        //now later on you can apply memoization if you want, simple as that
    }

    public static int[] solve(int si, int ei, char[] sym, boolean[] exp){
        if(si > ei){
            int[] base = new int[2];
            if(exp[si] == true) base[0]++; else base[1]++;
            return base;
        }

        int[] curr = new int[2];
        for(int i = si ; i <= ei; i++){
            int[] left = solve(si, i-1, sym, exp);
            int[] right = solve(i+1, ei, sym, exp);

            if(sym[i] == '&'){
                curr[0] += left[0]*right[0];
                curr[1] += left[1]*right[0] + left[1]*right[1] + left[0]*right[1];
            }

            if(sym[i] == '|'){
                curr[0] += left[1]*right[0] + left[0]*right[0] + left[0]*right[1];
                curr[1] +=  left[1]*right[1];
            }

            if(sym[i] == '^'){
                curr[1] += left[0]*right[0] + left[1]*right[1];
                curr[0] += left[1]*right[0] + left[0]*right[1];
            }
        }

        return curr;
    }
    
}
