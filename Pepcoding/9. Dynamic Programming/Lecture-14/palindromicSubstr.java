import java.util.HashSet;
import java.util.Set;

public class palindromicSubstr{

    public static void main(String[] args)  {
        String str = "geek";
        int ans = palindromeSubStrs(str);
        System.out.println(ans);
    }

    //DISTINCT

    //SOLVED BABY!!! Easy as fuckkk for sure!! (no worries for this one!)
    public static int palindromeSubStrs(String str) { 
        //all palindromic substring first
        //put in set
        //done!!

        //first method
        //you could use DP method (i-j) if 1 then put that string into that bitch 
        //O(n^2) - O(n^2)
        //second method
        //Expand method 
        //O(n^2) - O(1)

        //just solve it and submit it no?
        Set<String> set = new HashSet<>();

        //let's solve this question once for real now!! please
        int n = str.length();
        for(int i= 0; i < 2*n - 1;  i++){
            int l = i%2 == 0 ? i/2 : i/2;
            int r = i%2 == 0 ? i/2 : i/2 + 1;

            while(l >= 0 && r < n){  //can not be 11 either
                if(str.charAt(l) == str.charAt(r)){
                    set.add(str.substring(l, r+1));
                }else break;
                l--;
                r++;
            }
        }

        return set.size();
    }


}