import java.util.*;

public class diagonalTraversal {
    public static void main(String[] args) {
        
    }

    //this question requires some more self time to be figured out
    //give it that much and make it sure for real
    //left view and left boundary???

    public List<List<Integer>> diagonalTraversal(TreeNode root){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] min = new int[1];

        helper(root, 0, 0, map);
        List<List<Integer>> ans = new ArrayList<>();
        //which diagonal first?
        //figure that out first
        //can't we just map function for returning us the minimum value?????
        //figure this out , figure these codes out next time you are reading them please
        int d = min[0];
        

        //try solving for both diagonals on recursive as well as iterative, both are importatnt
        //do spend good enough time on both of this please for sure, very important
        while(map.containsKey(d)){
            ans.add(map.get(d));
            d+=2;
        }

        return ans;
    }
    
    public void helper(TreeNode root, int level, int width,int[]min, HashMap<Integer, List<Integer>> map){
        if(root == null) return;

        //hit karna aana chahiye bc
        int sum = level + width;
        if(!map.containsKey(sum)){
            map.put(sum, new ArrayList<>());
        }

        map.get(sum).add(root.val);
        if(min[0] < width){
            min[0] = width;
        }

        helper(root, level+1, width-1,min, map);
        helper(root, level+1, width+1,min, map);
    }
}
