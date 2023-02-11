import java.util.*;

public class magneticForce{

    //let's figure this bad boi out
    //SUCCESS ON THE VERY FIRST TRY BOIS
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int si = 1;
        int ei = position[n-1] - position[0];

        int ans = 0;
        while(si <= ei){
            int mid = (si + (ei-si)/2);
            if(check(position, m, mid)){
                ans = Math.max(ans, mid);
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }

        return ans;
    }

    public boolean check(int[] position, int m, int force){
        int cballs = 1;
        int last = position[0];
        int n = position.length;

        for(int i= 0; i < n; i++){
            if(position[i] - last >= force){
                cballs++;
                last = position[i];
            }
        }

        return cballs >= m;
    }
}