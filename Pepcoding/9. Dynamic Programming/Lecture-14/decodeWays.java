public class decodeWays {
    
    public static void main(String[] args) {
        //Time - O(n)
        //Space - O(1)

        //solve with these constraints for sure
        // *** first and basic logic is always use using recursion concepts ***
        int ans = numDecodings("121361410126");
        System.out.println(ans);

    }

    //as you can see some stupid cases are pre handled in this superb code, so know that always
    //like always two digits are undertaken in this code!! (which is pretty dope shit for sure)
    //always be aware of that!! boi!!! i love this question!! (thanks for this code)
    public static int numDecoding(String s) {
        int len = s.length();
        int last = 1;
        int slast = s.charAt(len - 1) == '0' ? 0 : 1;

        for(int i = len - 2; i >= 0; i--){
            int curr = 0;
            int d1 = s.charAt(i) - '0';
            if(d1 != 0){
                curr = slast;
                int num = (d1 * 10  + (s.charAt(i +1) - '0'));
                if(num <= 26){
                    curr += last;
                }
            }
            last = slast;
            slast = curr;
        }

        return slast;
    }



    //This below is my solve for sure!! (now figure out what solve you are offering for us to do???)
    //MY SOLVE
    public static int numDecodings(String s) {
        char[] str = s.toCharArray();  //after this what next?
        int nextnext = 1;
        int next = 1;
        int len = s.length();

        for(int i = len - 1; i >= 0; i--){
            if(str[i] == '0'){
                nextnext = next;
                next = 0;
            }else{
                int curr = 0;
                curr += next;
                if(i < len-1){
                    String num = s.substring(i, i+2);
                    int val = Integer.parseInt(num);
                    if(val <= 26){
                        curr += nextnext;
                    }
                }
                nextnext = next;
                next = curr;
            }
        }

        return next;
    }
    
}
