
class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {

    	long[] store = new long[k];
    	long ans = 0;

    	for(int i= 0; i < n; i++){
    		int curr = arr[i];

    		int get = curr % k;
    		int req = k - get;

    		ans += store[req];
    		store[get]++;
    	}

    	return ans;    
    }
}