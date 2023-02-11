import java.util.Arrays;

public class jumpGame2 {

    public static void main(String[] args) {
        //figuring this out gotta be pretty pretty important for sure
        //this would help us solve many many problems in no time brother (my balls are hella softy)
        int[] nums = {2,3,1,1,4};
        int ans = jump(nums);
        System.out.println(ans);
    }

    //sir method
    //no extra space - use of two pointers

    //way less and cooler code, using pretty much exact same my logic
    //but no fucking space cause of marking two pointers!!!! - dope shit
    public static int jumpSir(int[] nums) {
        int cjump = 0;
        int njump = 0;
        int ans = 0;
        int i = 0;
        while(i < nums.length){
            if(cjump >= nums.length - 1) return ans;

            njump = Math.max(njump, nums[i] + i);
            if(cjump == i){
                ans++;
                cjump = njump;
            }
            
            i++;
        }
        return ans;
    }

    //MY METHOD - without using two pointers, but more spaces
    //damn it fucking ran again, using my brilliant method for appreciation
    //i am pretty good at this for sure
    //we will figure out sir method now!!!!
    //finish this lecture asap for sure!!! (do other stuff too)
    public static int jump(int[] nums) {
        //i think so pretty much the same question for sure
        int curr = 0;
        int n = nums.length;

        int[] counter = new int[n];  //extra space used!!
        counter[0] = 0;
        
        for(int i= 0; i < n; i++){
            if(nums[i] + i > curr){  //update this bad boi and counter 
                int before = curr;
                curr = nums[i] + i;

                if(curr > n-1) curr = n - 1; 
                for(int j = before + 1; j <= curr; j++){
                    counter[j] = counter[i] + 1;  //simple i guess
                }
            }

            if(curr == n-1) break;
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(counter));
        return counter[n-1];
    }
    
}
