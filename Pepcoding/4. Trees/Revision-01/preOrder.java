  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

	//recursive solution bois
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> order = new ArrayList<>();
    	preOrderHelper(root, order);
    	return order;
    }

    //helper function for the question
    public void preOrderHelper(TreeNode node, List<Integer> order){
    	if(node == null){
    		return;
    	}

    	order.add(node.val);
    	preOrderHelper(node.left, order);
    	preOrderHelper(node.right, order);
    }


    class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;
        }
    }


    class travel{
        TreeNode node;
        boolean sd = false;
        boolean ld = false;
        boolean rd = false;

        travel(TreeNode node){
            this.node = node;
        }
    }


    //iterative solution bois  (brute force would be that only)
    //iterative solution is pretty dope for sure
    public List<Integer> InOrderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> inOrderTraversal = new ArrayList<>();
        Stack<travel> st = new Stack<>();
        st.push(new travel(root));

        while(!st.isEmpty()){
            travel curr = st.peek();  //get the current one pointer

            if(!curr.ld){
                if(curr.node.left != null)
                    st.push(new travel(curr.node.left));

                curr.ld = true;
            }else if(!curr.sd){
                inOrderTraversal.add(curr.node.val);
                curr.sd = true;
            }else if(!curr.rd){
                if(curr.node.right != null)
                    st.push(new travel(curr.node.right));

                curr.rd = true;
            }else{
                st.pop();
            }
        }

        return inOrderTraversal;
    }

}












