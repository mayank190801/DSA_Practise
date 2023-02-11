import java.util.Arrays;

public class LIS{
    //think of this logic (for sure)
    public static void main(String[] args) {
        int[] nums = {1,7,8,3,2,5,9,6,4,2,7,3};

        // //i could do below stuff using static variables too
        // int ans = 1;
        // for(int i=nums.length-1; i>= 0; i--){
        //     int recans = lengthOfLISRec(nums, i);
        //     ans = Math.max(recans, ans);
        // }

        // int[] oans = new int[1];
        // // lengthOfLISRec(nums, nums.length-1, oans); //call mardo bas
        // lengthOfLISRec(nums, nums.length-1, oans, new int[nums.length+1]);
    
        // System.out.println(ans);
        // System.out.println(oans[0]);
        // // System.out.println(oans[0]);

        int ans2 = LIS(nums);
        System.out.println(ans2);
    }

    //RECURSION METHOD
    public static int lengthOfLISRec(int[] nums, int eidx) {
        int ans = 1;
        for(int j = eidx-1; j >= 0; j--){
            if(nums[j] < nums[eidx]){
                int recans = lengthOfLISRec(nums, j);
                ans = Math.max(ans, recans + 1);
            }
        }        
        return ans;
    }

    //RECURSION OVERALL ANSWER TRICK 
    //think about this for once
    //We will run on every index once now
    public static int lengthOfLISRec(int[] nums, int eidx, int[] oans) {
        int ans = 1;
        for(int j = eidx-1; j >= 0; j--){
            int recans = lengthOfLISRec(nums, j, oans);  //sabpe call lgegei (this line is imp)
            if(nums[j] < nums[eidx]){
            ans = Math.max(ans, recans + 1);
            }
        }      

        oans[0] = Math.max(oans[0], ans);
        return ans;
    }

    //MEMOIZE
    public static int lengthOfLISRec(int[] nums, int eidx, int[] oans, int[]dp) {
        int ans = 1;
        //check
        if(dp[eidx] != 0){
            return dp[eidx];
        }

        for(int j = eidx-1; j >= 0; j--){
            int recans = lengthOfLISRec(nums, j, oans, dp);  //sabpe call lgegei (this line is imp)
            if(nums[j] < nums[eidx]){
            ans = Math.max(ans, recans + 1);
            }
        }      

        oans[0] = Math.max(oans[0], ans); //update final ans
        //update
        return dp[eidx] = ans;
    }

    //DP - 1
    //O(n^2) time
    //O(n) space
    public static int LIS(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        int ans = 1;

        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]); //this was nice for sure!!
        }

        System.out.println(Arrays.toString(dp));
        return ans;
    }

    //HW, think about answer creation using above code!!! (imp & could be asked in interview)
    //i have noticed something pretty cool, whenever we are mostly trying to reduce the complexity
    //of the code, space automatically increase bro
    
    //SOLVING IT IN O(nlogn) now (only count) //can only give lenght for sure
    //DP - 2
    //O(nlong) time
    //O(n) space
    //THIS IS SUPER DUPER FAST MAN!!!!!!!
    //only 3 ms required to run this code 
    public static int LISlogn(int[] nums){
        int ans = 1;
        for(int i = 1; i < nums.length; i++){
            int cidx = binarySearch(nums, 0, ans-1, nums[i]);
            if(cidx == ans){
                ans++;
            }
            nums[cidx] = nums[i]; //always gonna happen bois
        }
        return ans;
    }
    
    public static int binarySearch(int[] nums, int si, int ei ,int val){
        while(si <= ei){
            int mid = (si + ei)/2;
            if(nums[mid] == val){
                return mid;
            }else if(nums[mid] < val){
                si = mid + 1;
            }else{
                ei = mid - 1;
            }

            return si;  //simple as that bruh
        }
    }

    //binary search for similar values too
    public static int binarySearchSimilar(int[] nums, int si, int ei ,int val){
        while(si <= ei){
            int mid = (si + ei)/2;
            if(nums[mid] <= val){
                si = mid + 1;
            }else{
                ei = mid - 1;
            }

            return si;  //simple as that bruh
        }
    }
    





}