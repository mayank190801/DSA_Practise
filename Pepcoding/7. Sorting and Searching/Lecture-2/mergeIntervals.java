import java.util.ArrayList;
import java.util.Arrays;

public class mergeIntervals {
    public static void main(String[] args) {
        
    }

    //let's do this one
    //PRETTY DOPE, RUNS IN 12ms
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        //we have sorted it now, let's move forward
            //we can use two pointers complex approach
            //or STACK SHIT

        ArrayList<int[]> ans = new ArrayList<>();

        ans.add(new int[]{intervals[0][0], intervals[0][1]});
        int n = intervals.length;
        for(int i = 1; i < n; i++){
            int[] prev = ans.get(ans.size()-1);
            int[] curr = intervals[i];

            //now we have both prev and curr
            if(curr[0] > prev[1]){
                ans.add(curr);
            }else{
                if(curr[1] > prev[1]){
                    prev[1] = curr[1];
                }
            }
        }

        int[][] answer = new int[ans.size()][2];
        for(int i= 0; i < ans.size(); i++){
            answer[i][0] = ans.get(i)[0];
            answer[i][1] = ans.get(i)[1];
        }

        return answer;
    }
    
}
