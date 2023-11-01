public class leetcode20 {

    public static void main(String[] args) {

    }

    //lets figure out how this could work
    public static boolean isSubsequence(String s, String t) {
        int ptrOne = 0;
        int ptrTwo = 0;
        int sLen = s.length();
        int tLen =t.length();

        //if these two are the conditions which makes sense right
        while(ptrOne < sLen && ptrTwo < tLen){
            if(s.charAt(ptrOne) == t.charAt(ptrTwo)) ptrOne++;
            ptrTwo++;
        }
        return ptrOne == sLen;
    }



}
