public class subsequence2 {
    public static void main(String[] args) {
        subseq("aabbaabb", "", true, 0);
    }

    //pretty stupid only works for one fucking case 
    //"aabbbcccccdddd"
    public static void subseq(String str, String ans, boolean coming, int idx) {
        if(idx == str.length()){
            System.out.println(ans);
            return;
        }

        if(coming){
            subseq(str, ans + str.charAt(idx), true, idx + 1);
            subseq(str, ans, false, idx + 1);
            
        }else{
            
            if(str.charAt(idx) == str.charAt(idx - 1)){
                subseq(str, ans, false, idx + 1);
            }else{
                subseq(str, ans + str.charAt(idx), true, idx + 1);
                subseq(str, ans, false, idx + 1);
            }
        }
    
    }
    
}
