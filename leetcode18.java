import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode18 {
    public static void main(String[] args) {

    }

    //
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> ans = new ArrayList<>();
         ans.add(new ArrayList<>(Arrays.asList(1)));
         for(int i = 1; i < numRows; i++){
             List<Integer> temp = new ArrayList<>();
             temp.add(1);
             for(int j = 0; j < ans.get(i-1).size() - 1; j++){
                temp.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j + 1));
             }
             temp.add(1);
             ans.add(temp);
         }
        return ans;
    }
}
