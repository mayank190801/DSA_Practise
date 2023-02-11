public class longestBitonic {
    
    //this is pretty cool for sure man!!!!
    //this code went perfectly for sure (heheheheh, i love it man)
    public static int LongestBitonicSequence(int[] nums)
    {
        //let's think about this first
        //LIS from start, LIS from end (that's it)

        int n = nums.length;
        int[] one = new int[n];
        int[] two = new int[n];

        //normal LIS in O(nsquare)
        for(int i = 0; i < n; i++){
            one[i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    one[i] = Math.max(one[i], one[j] + 1);
                }
            }
        }

        //do same but in reverse order friend
        for(int i = n-1; i >= 0; i--){
            two[i] = 1;
            for(int j = i+1; j < n; j++){
                if(nums[j] < nums[i]){
                    two[i] = Math.max(two[i], two[j] + 1);
                }
            }
        }

        
        //now apply some linear check
        int ans = 1;
        for(int i= 0; i < n; i++){
            ans = Math.max(ans, one[i] + two[i] - 1);
        }
        return ans;

        //now on the array one , the thing is we have fucked the entire answer of this question
        //we had to do O(n^2) approach!!! not O(nlogn)
        //O(nlogn) gives shit bruh (it gives nothing bruh)
        //idiot for fuck sake man!! ( i kinda hate your focus now !!!) 
        //FUCKING GET GOOD AT DP dickhead
    }

    
}
