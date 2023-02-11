import java.util.ArrayList;

public class combinationSum1 {
    public static void main(String[] args) {
        
    }

    //lots of question revise for sure my friend, just code them once again, and with speed for sure
    //for sure more speed matters in here
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //i need to sent both of these stuff
        List<List<Integer>> ans = new ArrayList<>();  
        ArrayList<Integer> current = new ArrayList<>();

        combinationSum(candidates,target,0,current,ans);
        return ans;
    }

    public static void combinationSum(int[] candidates, int target, int index, ArrayList<Integer> current, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }
    
        for(int i = index; i < candidates.length; i++){
            if(target - candidates[i] >= 0){
                current.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i, current, ans);
                current.remove(current.size() - 1);
            }
        }
    }

    
}
