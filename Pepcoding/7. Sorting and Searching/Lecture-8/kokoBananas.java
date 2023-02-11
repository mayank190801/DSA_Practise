public class kokoBananas {

    //this is simple as that
    //SOLVED BOI
    //Just changing from long to int also speeds up the code
    public int minEatingSpeed(int[] piles, int h) {
        int si = 1;
        int ei = 0;

        for(int i : piles){
            ei = Math.max(i, ei);
        }

        int min = ei;
        while(si <= ei){
            int mid = (si + (ei -si) / 2 );  //optimised version
            if(check(piles, h, mid)){
                min = Math.min(mid, min);
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }

        return min;
    }

    public boolean check(int[] piles, int h, int limit){
        //how many
        int ch = 0;
        for(int i= 0; i < piles.length; i++){
            int val = piles[i];
            ch += val/limit;
            if(val%limit != 0) ch++;
        }

        return ch <= h;
    }
    
}
