public class decodeWays2{
    public static void main(String[] args) {

        int ans = numDecodings("904");
        System.out.println(ans);
        
    } 

    //SIR SOLVE BABIES
    //convert this baby into mod and stuff simple
    public static int numDecoding(String s) {  
        int len = s.length();
        long last = 0;
        long slast = s.charAt(len - 1) == '0' ? 0 : s.charAt(len - 1) == '*' ? 9 : 1;

        for(int i = len - 2; i >= 0; i--){
            int curr = 0;
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);

            if(s.charAt(i) == '0'){

            }else if(s.charAt(i) == '*'){
                curr = (slast * 9); //sinlge digit
                if(ch2 == '*'){
                    curr += (last) * 15;
                }else{
                    int d2 = ch2 - '0';
                    if(d2 <= 6 ){
                        curr += (last) * 2;
                    }else{
                        curr += last;
                    }
                }
            }else{
                curr += slast;
                if(ch2 == '*'){
                    if(ch1 == '1'){
                        curr += (last) * 9;
                    }else if(ch1 == '2'){
                        curr += (last) * 6;
                    }
                }else{
                    int num = ((ch1) -'0') * 10 + (ch2 - '0'));
                    if(num <= 26){
                        curr += last;
                    }
                }
            }

            last = slast;
            slast = curr;
        }
    
        return slast;
    }

    //I did solve it somehow for fucking sake
    //Prettty annoying as fuck code for sure!!! (totally totally totally hate it boss!!!)
    //not really interested in for real
    //LET'S FIGURE SIR METHOD NOW 
    public static int numDecodings(String s) {  //itna toh socho hi ni boss!! (simple raho simple jio)
        //convert this code to absorb modulo and stuff for sure!! 
        //pretty tricky but it's important
        long mod = 1000_000_007L;

        int len = s.length();
        long last = 1;
        long slast = s.charAt(len - 1) == '0' ? 0 : s.charAt(len - 1) == '*' ? 9 : 1;
        // System.out.println(slast);

        for(int i = len - 2; i >= 0; i--){
            //why not crack google boss?? (simple try for google bruh!! and crack it if you can!!!!)
            //four conditions all in all
            long curr = 0;

            if(s.charAt(i) != '0'){
                if(s.charAt(i) != '*' && s.charAt(i+1) != '*'){
                    //none
                    curr = slast;
                    long num = ((s.charAt(i)-'0') * 10  + (s.charAt(i +1) - '0'));
                    if(num <= 26){
                        curr = (curr + last)%mod;
                    }

                }else if(s.charAt(i) != '*' && s.charAt(i+1) == '*'){
                    //right
                    curr = slast;
                    long count = 0;
                    if(s.charAt(i) - '0' == 1){
                        count = 9;
                    }else if(s.charAt(i) - '0' == 2){
                        count = 6;
                    }
        
                    curr = (curr + (last * count)%mod)%mod;
                }else if(s.charAt(i) == '*' && s.charAt(i+1) != '*'){
                    //left 
                    curr = (slast * 9L)%mod;
                    long count = 1;
                    if((s.charAt(i+1) - '0') <= 6) count++;

                    curr = (curr + (last * count)%mod)%mod;
                }else{
                    //both
                    curr = (slast * 9)%mod;
                    int count = 15;
                    curr = (curr + (last * count)%mod)%mod;
                }
            }

            // System.out.println(curr + " " + last + " " + slast);
            last = slast;
            slast = curr;
        }

        return (int)(slast%mod);
    }

}
