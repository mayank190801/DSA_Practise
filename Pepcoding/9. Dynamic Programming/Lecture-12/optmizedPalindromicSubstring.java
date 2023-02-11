
public class optmizedPalindromicSubstring {

    public static void main(String[] args) {

        //longest Palindromic Substring
        solve();
        
    }

    public static void solve(){
        //longest Palindrome optimised
        //O(n^2) && O(1) space

        //recursion
        //current check , or  max(i+1, j , i, j-1) check simple

        //count Palindrome optimised
        //O(n^2) && O(1) space

        //EVEN MORE OPTIMISED
        //KMP , MANACHER AND SHIT (study them later on!!) (tho most imp)
    }

    //going at every index, and then expanding left and right from there
    //simply opposite of the last method
    //this is the basic method, i thought of when i basically started coding
    //such a simple question and logic, which get blurred when you learn too much
    //hehehehehe

    public String longestPalindrome(String s){
        int n = s.length();
        int st = 0;
        int end = 0;
        for(int i = 0; i < 2*n -1 ; i++){
            int left = ((i+1)/2) - 1;
            int right = (i%2 == 0) ? left +2 : left +1 ;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(end - st + 1 < right - left - 1){
                st = left + 1;
                end = right - 1;
            }
        }
        return s.substring(st, end + 1);
    }

    //Count
    //13 ms (same code as below, but char arr is used in there)
    public int countPalindrome(String s){
        int n = s.length();
        int ans = 0;
       
        for(int i = 0; i < 2*n -1 ; i++){
            if(i%2 == 0) ans++; //that index is certainly skipped

            int left = ((i+1)/2) - 1;
            int right = (i%2 == 0) ? left +2 : left +1 ;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                ans++;
                left--;
                right++;
            }
      
        }
        
        return ans;
    }

    //my kind of optimisation now
    //3 ms
     public int countPalindromeMyKind(String s){

        char[] str = s.toCharArray();

        int n = s.length();
        int ans = 0;
       
        for(int i = 0; i < 2*n -1 ; i++){
            if(i%2 == 0) ans++; //that index is certainly skipped

            int left = ((i+1)/2) - 1;
            int right = (i%2 == 0) ? left +2 : left +1 ;
            while(left >= 0 && right < n && str[left] == str[right]){
                ans++;
                left--;
                right++;
            }
      
        }
        
        return ans;
    }

    
}
