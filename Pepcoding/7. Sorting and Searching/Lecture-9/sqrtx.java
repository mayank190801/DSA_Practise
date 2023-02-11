public class sqrtx {

    //perfectly solvable for sure, baby
    public int mySqrt(int x) {
        long si = 0;
        long ei = x;

        long ans = 0;
        while(si <= ei){
            long mid = (si + (ei-si)/2);
            if(mid*mid <= x){
                ans = Math.max(ans,mid);
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }

        return (int)ans;
    }
    
}
