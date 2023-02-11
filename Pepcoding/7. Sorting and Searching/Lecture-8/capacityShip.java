public class capacityShip {

    //let's solve this bad boi
    //PERFECT SOLVE BOIS
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        for(int i : weights) max += i;
        
        //use this below, and reduce code complexity in below solve
        int si = 0;
        int ei = max;

        int min = max;
        while(si <= ei){
            int mid = (si+ei)/2;
            if(check(weights,mid,days)){
                ei = mid-1;
                min = Math.min(mid, min);
            }else{
                si = mid+1;
            }
        }
        
        return min;
    }

    public static boolean check(int[]weights, int limit, int days){
        int csum = 0;
        int cdays = 1;

        for(int i= 0; i < weights.length; i++){
            if(weights[i] + csum <= limit){
                csum += weights[i];
            }else{
                if(weights[i] > limit){
                    return false;
                }else{
                    csum = weights[i];
                    cdays++;
                }
            }
        }

        return cdays <= days;
    }
    
}
