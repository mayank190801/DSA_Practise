public class leetcode2433 {
    //achcha I understood the question hi wrong pura!
    //Pretty stupid for sure
    public static void main(String[] args) {
//        System.out.println(7 ^ 7);
        int[] temp = {5,2,0,3,1};
        findArray(temp);
    }

    public static int[] findArray(int[] pref) {
        int n = pref.length;
        int[] ans = new int[n];
        int curr = 0;
        for(int i = 0; i < n; i++){
            curr = curr ^ pref[i];
            System.out.println(curr + " " + pref[i]);
            ans[i] = curr;
        }
        return ans;
    }
}
