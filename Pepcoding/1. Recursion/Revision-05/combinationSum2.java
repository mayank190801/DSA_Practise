import java.util.ArrayList;

import javax.naming.ldap.SortControl;

public class combinationSum2 {
    public static void main(String[] args) {
        
    }

    //keep coding, keep growing
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        sort(candidates);  //simply logical
        List<List<Integer>> ans = new ArrayList<>();  
        ArrayList<Integer> current = new ArrayList<>();

        solver(candidates, target, 0, true, current, ans);
        return ans;
    }

    public static void solver(int[] candidates, int target, int index, boolean taken, ArrayList<Integer> current, List<List<Integer>> ans){
        if(index == candidates.length){
            if(target == 0){
                //one fucking piece of editing for sure
                ans.add(new ArrayList<>(current));
            }
            return;
        }

        if(taken){
            solver(candidates, target, index + 1, false, current, ans);
            if(target - candidates[index] >= 0){
                current.add(candidates[index]);
                solver(candidates, target - candidates[index], index + 1, true, current, ans);
                current.remove(current.size() - 1);
            }
        }else{
            if(candidates[index] == candidates[index - 1]){
                solver(candidates, target, index + 1, false, current, ans);
            }else{
                solver(candidates, target, index + 1, false, current, ans);
                if(target - candidates[index] >= 0){
                    current.add(candidates[index]);
                    solver(candidates, target - candidates[index], index + 1, true, current, ans);
                    current.remove(current.size() - 1);
                }   
            }
        }
    }

    
}
