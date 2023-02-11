import java.util.ArrayList;

public class allFullBinaryTree {
    public static void main(String[] args) {
        
    }

    //0 children or 2 children, how many fbt possible? tell
    //tell tell no bitch
    //sir gonna help
    //ALL FULL BINARY TREE
    public List<TreeNode> allPossibleFBT(int n) {

        List<TreeNode> ans = new ArrayList<>();
        if(n%2 == 0) return ans;

        if(n == 1){
            TreeNode node =new TreeNode(0);
            ans.add(node);
            return ans;
        }

        for(int i = 1; i < n; i+=2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(0);
                    node.left =l;
                    node.right =r;
                    ans.add(node);
                }
            }
        }

        return ans;
    }

    //now this was pretty clear, this question is all about faith
    //think how you can make faith my friend
    //pls faith, believe in faith and solve these stupid questions


}
