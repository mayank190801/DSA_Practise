import java.util.Collections;
import java.util.List;

class leetcode2 {
    public static int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        // Collections.sort(tasks, (a,b) -> b - a);
        Collections.sort(tasks, Collections.reverseOrder());
        int ans = 0;
        for(int i = 0; i < processorTime.size(); i++){
            ans = Math.max(ans, processorTime.get(i) + tasks.get(i*4));
        }
        return ans;
    }
}