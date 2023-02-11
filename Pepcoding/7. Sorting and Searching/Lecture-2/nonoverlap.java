import java.util.Arrays;

public class nonoverlap {
    public static void main(String[] args) {
        
    }

    //let's solve this bad boi
    //this method works boi
    //NON OVERLAPPING FOR MIN INTERVAL
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int ans = 0;

        //now simply figure stuff out 
        int left = 0;
        int right = 1;

        while(right < intervals.length){
            int[] l = intervals[left];
            int[] r = intervals[right];

            //merging case
            if(r[0] < l[1]){
                ans++;
                if(r[1] > l[1]){
                    right++;
                }else{
                    left = right;
                    right++;
                }
            }else{
                left = right;
                right++;
            }
        }
    
        return ans;
    }
    
}
