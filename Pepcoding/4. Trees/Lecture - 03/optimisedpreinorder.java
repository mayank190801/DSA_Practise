import java.util.HashMap;
import java.util.Map;

//definitely a bit optimised, not a hard thing to think about for sure
//you know this from the very start, think and resolve, think and resolve
public class optimisedpreinorder{
    
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
   
    //PRE and IN creation of Tree
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //i have to properly construct a tree like this and that to be honest        
        Map<Integer, Integer> pos = new HashMap<>();
        for(int i= 0; i < inorder.length; i++){
            pos.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, pos);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int ps, int pe, int ls, int le , Map<Integer, Integer> pos){

        if(ps > pe){
            return null;
        }

        int i = pos.get(preorder[ps]);
        
        TreeNode temp = new TreeNode(preorder[ps]);
        int lcount = i - ls;
        temp.left = helper(preorder, inorder, ps+1 , ps+lcount , ls, ls +lcount-1, pos);
        temp.right = helper(preorder, inorder, ps+lcount+1, pe, ls+lcount+1, le, pos);
        return temp;

    }

}