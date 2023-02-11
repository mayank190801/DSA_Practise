
class Solution
{
   public long subCount(long arr[] ,int n,int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int ans = 0;
        int sum = 0;

        for(int i= 0; i < n; i++){
            sum += arr[i];

            sum = sum%k;
            if(sum < 0 || sum >= k){
               sum = (sum + k)%k;
            }

            ans += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
      
         return ans;
    }
}