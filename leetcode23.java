public class leetcode23 {
    public static void main(String[] args) {

    }

    //let's figure this out brother
    //just convert this into a better themed question, and you are good to go
    public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int dp1 = 1, dp2 = 1, ans = 1;
        for(int i = 1; i < len; i++){
            int t1 = Math.max(nums1[i] >= nums1[i - 1] ? dp1 + 1 : 1, nums1[i] >= nums2[i - 1] ? dp2  + 1 : 1);
            int t2 = Math.max(nums2[i] >= nums1[i - 1] ? dp1 + 1: 1, nums2[i] >= nums2[i - 1] ? dp2 + 1: 1);
            dp1 = t1;
            dp2 = t2;
            ans = Math.max(ans, Math.max(t1, t2));
        }
        return ans;
    }
}
