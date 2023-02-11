public class firstBad {
    public static void main(String[] args) {
        
    }

    //let's solve it out for now
    //solved baby
    public int firstBadVersion(int n) {

        //bool isBadVersion(version) //given api
        int si = 1;
        int ei = n;

        int ans = ei;
        while(si <= ei){
            int mid = (si + (ei - si)/2);
            if(isBadVersion(mid)){
                ans = Math.min(ans, mid);
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }

        return ans;
    }
    
}
