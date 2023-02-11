public class splitArray {

    //PERFECT CODE RUN BOSS
    public int splitArray(int[] nums, int m) {
        int si = 0;
        int ei = 0;

        for(int i : nums){
            si = Math.min(i, si);
            ei += i;
        }

        int ans = ei;
        while(si <= ei){
            int mid = (si + ei)/2; //adaptable for sure
            if(check(nums, m, mid)){
                ans = Math.min(ans, mid); //adaptable for sure
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }

        return ans;
    }

    public boolean check(int[] nums, int m, int limit){
        int cm = 1;
        int csum = 0;

        for(int i= 0; i < nums.length; i++){
            int val = nums[i];

            if(csum + val > limit){
                if(val > limit) return false;
                csum = val;
                cm++;
            }else{
                csum+=val;
            }
        }

        return cm <= m;
    }
}
