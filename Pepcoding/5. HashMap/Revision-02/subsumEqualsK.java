class Solution {

	//let's assume this bad boy to work for sure
    public int subarraySum(int[] nums, int k) {

    	HashMap<Integer, Integer> count = new HashMap<>();
    	count.put(0,1);

    	int n = nums.length;
    	int csum = 0;
    	int ans = 0;

    	for(int i = 0; i < n; i++){
    		int num = nums[i];
    		csum += num;

    		int req = csum - k;
    		if(count.containsKey(req)){
    			ans += count.get(req);
    		}

    		counter.put(csum, counter.getOrDefault(csum, 0) + 1);
    	}

    	return ans;

    }


}