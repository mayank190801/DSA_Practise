import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode9 {
    public static void main(String[] args) {

    }

    public static int sumCounts(List<Integer> nums) {
        int len = nums.size();
        int sum = 0;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                //so now we have an i and j
                Set<Integer> set = new HashSet<>();
                for(int k = i; k <= j; j++){
                    set.add(nums.get(k));
                }
               sum += set.size() * set.size();
            }
        }

        return sum;
    }

    public static  int minChanges(String s) {
        int len = s.length();
        int curr = -1;
        int cnt = 0;
        int fans = 0;
        for(int i = 0; i < len; i++){
            int val = s.charAt(i) - '0';
           if(curr == -1){
               curr = s.charAt(i) - '0';
               cnt++;
           }else{
              if(curr == val){
                  cnt++;
              }else{
                  if(cnt % 2 == 1){
                     fans++;
                     cnt++;
                  }else{
                      cnt = 0;
                      curr = -1;
                      i--;
                  }
              }
           }
        }
        return fans;
    }

}
