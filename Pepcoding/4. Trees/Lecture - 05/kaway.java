import java.lang.reflect.Array;
import java.util.*;

public class kaway{

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
    public static void main(String[] args) {
        

    }

    //no need of root, reference would work too for sure
    //heheh ease question for sure
    // ArrayList<Integer> Kdistance(TreeNode root, int k, TreeNode)
    // {
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     helper(ans, root, k);        
    //     return ans;
    // }

    void helper(ArrayList<Integer> ans , TreeNode root, int k, TreeNode block){
        if(root == null) return;
        if(root == block) return;

        if(k <= 0){
            if(k == 0)
                ans.add(root.val);
            return;
        }

        helper(ans, root.left, k-1, block);
        helper(ans, root.right, k-1, block);
    }

    public List<TreeNode> rootToNodePath(TreeNode root, int data){
        //now fix base cases
        List<TreeNode> answer = new ArrayList<>();
        if(root == null) return answer;

        if(root.val == data){
            answer.add(root);
            return answer;
        }

        List<TreeNode> left = rootToNodePath(root.left, data);
        List<TreeNode> right = rootToNodePath(root.right, data);

        if(left.size() > 0){
            left.add(root);
            return left;
        }

        if(right.size() > 0){
            right.add(root);
            return right;
        }

        return answer;
    }

    //above code is k down code tbh, it's annoying so ignore it for sure
    //K AWAY using EXTRA SPACE (ROOT TO NODE PATH)

    //first find the path, and then apply on everyone bitch
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        List<TreeNode> path = rootToNodePath(root, target.val);
        
        //3,2,1 and so on 
        //whatever i thought of is basically done in here
        TreeNode block = null;
        //this below function would have some criterias to basically tho
        for(int i= 0; i < path.size(); i++){
            if(k - i < 0) break;

            helper(ans, path.get(i), k-i, block);
            block = path.get(i);
        }

        return ans;
    }

    //DAMN THIS ABOVE CODE REALLY WORKS BRUH
    //definitely pretty cool for sure, i love it 


    //K AWAY WITHOUT EXTRA SPACE
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        help(root, target.val, k, ans);
        return ans;
    }

    //i did found the error but i couldn't fix that error for sure
    public int help(TreeNode root, int data, int k , ArrayList<Integer> ans){
        //base cases
        if(root == null) return -1;
        if(root.val == data){
            helper(ans, root, k, null);
            return 1;
        }

        //faith in the question
        int left = help(root.left, data, k, ans);
        if(left != -1){
            helper(ans, root, k-left, root.left);
            return left+1;
        }

        int right = help(root.right, data, k, ans);
        if(right != -1){
            helper(ans, root, k-right, root.right);
            return right+1;
        }
    
        //nothing works case for sure
        return -1;
    }

}