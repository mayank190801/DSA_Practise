class Solution {

    //a lil typical to code for sure, three cases, if both up and down exist, 
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;

        for(int i= 0; i < nums.length; i++){

            int curr = nums[i];
            if(map.containsKey(curr)) continue; 

            boolean up = map.containsKey(curr - 1);
            boolean down = map.containsKey(curr + 1);

            if(up && down){

                //one case done
                int up = map.get(curr - 1);
                int down = map.get(curr + 1);

                int sum = map.get(curr - 1) + 1 + map.get(curr + 1);

                map.put(curr - up, sum);
                map.put(curr + down, sum);
                map.put(curr, sum);
                ans = Math.max(ans, sum);
                
            }else if(up){

                int up = map.get(curr - 1);
                int sum = map.get(curr - 1) + 1;
                map.put(curr - up, sum);                
                map.put(curr, sum);
                ans = Math.max(ans, sum);

            }else if(down){

                
                int down = map.get(curr + 1);
                int sum = 1 + map.get(curr + 1);
                map.put(curr + down, sum);
                map.put(curr, sum);
                ans = Math.max(ans, sum);

            }else{
                map.put(curr, 1);
                ans = Math.max(ans, 1);
            }

        }

        return ans;
    }

}