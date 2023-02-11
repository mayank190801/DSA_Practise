public class allPalindrome {

    //all palindrome check in O(1) 
    //learn this bad boi for real now!!! (imp)
    //dopest recursion + dp used in O(n^2) at max to make this work bois

    public static void main(String[] args) {
        String s = "aabbaac";
        int len = s.length();
        int[][] isPalindrome = new int[len][len];
        palindromeCreator(isPalindrome, s);
        //this works beautifully sure

        for(int[] arr : isPalindrome){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    //SIR CODE BOIS
    public static boolean[][] allpalin(String str){
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        
        //how to traverse half of the array!! 
        //pretty logical and better code for sure

        for(int gap = 0 ; gap < dp.length; gap++){
            int si = 0;
            int ei = gap;
            while(ei < dp.length){
                //1 length
                if(gap == 0){
                    dp[si][ei] = true;
                }else if(gap == 1){
                    if(str.charAt(si) == str.charAt(ei))
                        dp[si][ei] = true;
                }else{ for(int i = st+1; i < end; i++){
            int left = matrixMulti(N, arr, st, i, dp);
            int right = matrixMulti(N, arr, i, end, dp);

            int cans = left + right + (arr[st] * arr[i] * arr[end]);
            ans = Math.min(ans, cans);
        }
                    if(str.charAt(si) == str.charAt(ei) && dp[si+1][ei-1])
                        dp[si][ei] = true;
                }
                si++;
                ei++;
            }
        }

        return dp;
    }


    //let's write this function on our own right
    //and then do something else probablyyy no???? 
    //MY OWN WRITTEN CODE BOIS!!!! (PRETTY COOL)
    public static void palindromeCreator(int[][] isPalindrome, String str){

        int n = isPalindrome.length;
        int i = 0;
        int j = 0;

        while( i < n){
            isPalindrome[i][j] = 1;
            i++;
            j++;
        }

        i = 0;
        j = 1;
        while(j < n){
            if(str.charAt(i) == str.charAt(j))
                isPalindrome[i][j] = 1;
            i++;
            j++;
        }

        //after this loop main games start tbh
        i = 0;
        j = 2;
        while(j < n){
            //isme j bdao jalo, 
            int y = j;
            i = 0;
            while(y < n){
                if(str.charAt(i) == str.charAt(y) && isPalindrome[i+1][y-1] == 1)
                    isPalindrome[i][y] = 1;
                i++;
                y++;
            }
            j++;
        }
    }





    
}
