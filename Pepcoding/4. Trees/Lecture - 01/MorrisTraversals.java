import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class MorrisTraversals {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

    }
    
    //morris be smart af
    public List<Integer> inOrderMorris(TreeNode node){
        //minor changes done too
        List<Integer> ans = new ArrayList<>();

        while(node != null){
            if(node.left == null){
                ans.add(node.val);
                node = node.right;
            }else{
                //finding in the left ka atmost right
                var temp = node.left;
                while(temp.right != null && temp.right != node){
                    //moving on the right
                    temp = temp.right;
                }

                //checking for what came out baby
                //important
                if(temp.right == null){
                    temp.right = node;
                    //jump in left
                    node = node.left;
                }else {
                    temp.right = null;
                    //important position
                    ans.add(node.val);
                    //jump in right
                    node = node.right;
                }
            }
        }
        
        return ans;

    }

    //preorder
    public List<Integer> preOrderMorris(TreeNode node){
        //minor changes done too
        List<Integer> ans = new ArrayList<>();
        
        while(node != null){
            if(node.left == null){
                ans.add(node.val);
                node = node.right;
            }else{
                //finding in the left ka atmost right
                var temp = node.left;
                while(temp.right != null && temp.right != node){
                    //moving on the right
                    temp = temp.right;
                }

                //checking for what came out baby
                //important
                if(temp.right == null){
                    //important position
                    ans.add(node.val);
                    temp.right = node;
                    //jump in left
                    node = node.left;
                }else {
                    temp.right = null;
                    //jump in right
                    node = node.right;
                }
            }
        }
        
        return ans;

    }

    //why not in postorder baby?

}
