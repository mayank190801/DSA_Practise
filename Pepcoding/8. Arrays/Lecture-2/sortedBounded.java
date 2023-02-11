public class sortedBounded {


    //ONE method 
    //Find for max(max)
    //Find for max(min)
    //Subtract both of them to get your answer
    //This is two traversals and more logical one for sure

    //SECOND METHOD (SIR)
    //VALID VALUE ko store krenge (jispe in range hoga)
    //jab bhi out of range hoga, 
    //niche hua toh previou valid add kr do,
    //upar hua toh sab reset ho jaayega
    //MUCH EASIER IMPLEMENTATION THEN MINE

    //SECOND METHOD
    //MY METHOD (In single traversal)
    //     l   p    c
    //[73,55,36,5,55,14,9,7,72,52]
    //IN O(n) -> Brilliant solve according to me for sure
    //In single traversal tho bois

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        
        int l = 0;
        int c = 0;
        boolean flag = false;

        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];

            if(curr <= right && curr >= left){
                c = i;
                count += c-l+1;
                flag = true;
            }else if(curr < left){
                if(flag) count += c-l+1;
            }else{
                l = i+1;
                c = i+1;
                flag = false;
            }
        }

        return count;
    }
    
}
