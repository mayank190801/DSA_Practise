import java.util.HashMap;
import java.util.Map;

public class postPreorder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //use the optimised way in here
    //one edge case is there be sure to take it in consideration
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i= 0; i < postorder.length ; i++){
            map.put(postorder[i], i);
        }

        //now let's solve it, solve this piece of question for sure, and move on, move ahead, and conquer the world 
        //jog, jog, jog, jog, jog, jog, jog, jog, jog, jog, jgo, jog, jog, jog, jog, jog, jog, jog, jog
        return helper(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1, map);
        
    }

    //this code ran perfectly for sure
    public TreeNode helper(int[] pre, int ps, int pe, int[] post, int os, int oe, Map<Integer,Integer> map){
        //there are two end cases, figure that ou
        if(ps > pe) return null;

        TreeNode temp = new TreeNode(pre[ps]);
        if(ps == pe) return temp;

        //find that bad boy position
        int i = map.get(pre[ps+1]);

        int lcount = i - os +1;
        //update below shit too
        temp.left = helper(pre, ps+1, ps+lcount, post, os, os+lcount-1, map);
        temp.right = helper(pre, ps+lcount+1, pe, post, os+lcount, oe-1, map);
        return temp;
    }

    
}
