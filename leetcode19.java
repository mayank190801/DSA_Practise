public class leetcode19 {
    public static void main(String[] args) {

    }

    //this should be where you should be coding
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++){
            int cnt = 0;
            int curr = i;
            while(curr != 0){
                if((curr & 1) == 1) cnt++;
                curr = curr >> 1;
            }
            ans[i] = cnt;
        }
        return ans;
    }




}
