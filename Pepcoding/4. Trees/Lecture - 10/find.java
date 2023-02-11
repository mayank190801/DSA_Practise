import java.util.ArrayDeque;
import java.util.Queue;

public class find{
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

    //FIND (iterative method)
    //this does work tho boi
    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node.val == val){
                return node;
            }else if(node.val < val){
                if(node.right != null)
                    que.add(node.right);
            }else{
                if(node.left != null)
                    que.add(node.left);
            }
        }
        
        return null;
    }

    //SIR CODE IS DOPEST AS FUCK FOR SURE
    //HOW DOES HE IMPROVE EACH CODE BY SO SO SO SO SO MUCH
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode c = root;
        while(c != null){
            if(c.val == val){
                return c;
            }else if(c.val < val){
                c = c.right;
            }else{
                c = c.left;
            }
        }
        return null;
    }
}



