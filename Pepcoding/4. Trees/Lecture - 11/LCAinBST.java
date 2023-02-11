public class LCAinBST{

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        
    }

    //let's code it down

    //LCA IN BST
    //Iterative manner mein bhi solve ho gya dude
    //Going in the direction which we need only boi
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //or simply swap
        //or take the values themselves, as simple as that
        if(q.val < p.val){
            TreeNode t = p;
            p = q;
            q = t;
        }

        TreeNode curr = root;
        while(curr != null){
            if(curr.val >= p.val && curr.val <= q.val ){
                return curr;
            }else if(curr.val < p.val){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        return curr;
    }




}