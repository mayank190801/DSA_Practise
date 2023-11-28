import java.util.ArrayList;
import java.util.List;

public class leetcode33 {
    public static void main(String[] args) {
        generateTrees(3);
    }


    public static class TreeNode {
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
    public static List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public static  List<TreeNode> helper(int st, int en){
        List<TreeNode> ans = new ArrayList<>();
        if(st > en) {
            ans.add(null);
            return ans;
        }
        for(int i = st; i <= en; i++){
            List<TreeNode> left = helper(st, i-1);
            List<TreeNode> right = helper(i + 1, en);
            for(int j = 0; j < left.size(); j++){
                for(int k = 0; k < right.size(); k++){
                    TreeNode head = new TreeNode(i);
                    head.left = copyTree(left.get(j));
                    head.right = copyTree(right.get(k));
                    ans.add(head);
                }
            }
        }
        return ans;
    }

    //copy the given tree??
    public static TreeNode copyTree(TreeNode head){
        if(head == null) return null;
        TreeNode thead = new TreeNode(head.val);
        thead.left = copyTree(head.left);
        thead.right = copyTree(head.right);
        return thead;
    }



}
