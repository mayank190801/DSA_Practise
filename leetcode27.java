import java.util.ArrayList;

public class leetcode27 {
    public static void main(String[] args) {

    }

    //one more solution to my fuck up problem of travelling - I have the solution
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> solution = new ArrayList<>();
        int prev = 0;
        for(int i = digits.length - 1; i >= 0; i--){
           int curr = digits[i] + prev;
           prev = curr == 10 ? 1 : 0;
           solution.add(curr % 10);
        }
        if(prev == 1) solution.add(1);
        int[] ans = new int[solution.size()];
        for(int i = solution.size() - 1; i >= 0; i--){
            ans[solution.size() - i - 1] = solution.get(i);
        }
        return ans;
    }
}
