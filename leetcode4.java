public class leetcode4 {
    public static void main(String[] args) {

    }

    public static int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;
        int[][] ans = new int[n][m];

        //done for indexing 1 to n
        int[] rowWise = new int[n + 1];
        for(int i = 0; i < n; i++){
            int curr = 1;
            for(int j = 0; j < m; j++){
                curr = ((curr % mod) * (grid[i][j] % mod)) % mod;
            }
            rowWise[i + 1] = curr;
        }

        //done for this indexing as well simple as that
        int[] topRow = new int[n + 2];
        int[] bottomRow = new int[n + 2];
        topRow[0] = 1;
        for(int i = 0; i < n; i++){
            topRow[i + 1] = ((topRow[i] % mod) * (rowWise[i + 1] % mod)) % mod;
        }
        bottomRow[n + 1] = 1;
        for(int i = n; i > 0; i--){
            bottomRow[i] = ((bottomRow[i + 1] % mod) * (rowWise[i] % mod)) % mod;
        }


        //precomputation is done for this as well now, coding is slow but will get faster
        //now for the final answer time, something similar to this only needs to be done
        for(int i = 0; i < n; i++){
            int[] leftWise = new int[m + 2];
            int[] rightWise = new int[m + 2];
            leftWise[0] = 1;
            rightWise[m + 1] = 1;
            for(int j = 1; j <= m; j++){
                leftWise[j] = ((leftWise[j - 1] % mod) * (grid[i][j - 1] % mod)) % mod;
            }
            for(int j = m; j > 0; j--){
                rightWise[j] = ((rightWise[j + 1] % mod) * (grid[i][j - 1] % mod)) % mod;
            }
            for(int j = 0; j < m; j++){
                int currVal =  (((leftWise[j] * rightWise[j + 2])%mod) * ((topRow[i] * bottomRow[i + 2]) % mod)) % mod;
                ans[i][j] = currVal;
            }
        }
        return ans;
    }
}














