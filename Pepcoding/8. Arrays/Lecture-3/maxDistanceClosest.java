public class maxDistanceClosest{

    //METHOD SIR
    //he took two pointers, start and end, and find those two start and end
    //simple as that    
    //Annoying version to code for sure
    //Rather than storing count, you could just subtract st and end
    //His code was somehow faster than mine! (So yeah do remember that)

    //Run in O(N)
    //Space in O(1)
    //MY CODE (Run perfectly, let's see sir code)
    //MAX DISTANCE FROM ONE
    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        int count = 0;

        int i = 0;
        for(i= 0; i < seats.length; i++){
            if(seats[i] == 1){
                ans = count;
                count = 0;
                break;
            }else count++;
        }

        for(; i < seats.length; i++){
            if(seats[i] == 1){
                int curr = count/2;
                if(count % 2== 1) curr++;
                ans =  Math.max(ans, curr);
                count = 0;
            }else count++;
        }

        ans = Math.max(ans, count);
        return ans;
    }

}