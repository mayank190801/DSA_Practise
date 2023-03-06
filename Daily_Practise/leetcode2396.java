public class leetcode2396 {
    public static void main(String[] args) {
        System.out.println(Integer.toString(10,2));
    }

    public static boolean isStrictlyPalindromic(int n) {
        for(int i = 2; i <= (n-2); i++){
            String output = NbaseB(n, i);
            boolean pos = isPalindrome(output);

            if(!pos) return pos;
        }
        return true;
    }

    public static String NbaseB(int n, int b){
        StringBuilder sb = new StringBuilder();
        while(n >= b){
            sb.append(n%b);
            n = n/b;
        }
        sb.append(n);
        return sb.toString();
    }

    public static boolean isPalindrome(String given){
        int left = 0;
        int right = given.length() - 1;
        while(left < right){
            if(given.charAt(left) != given.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }


}
