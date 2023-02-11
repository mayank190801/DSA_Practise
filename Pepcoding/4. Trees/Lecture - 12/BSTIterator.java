public class BSTIterator {

    //DAMN IT DID RUN
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }    

    TreeNode curr = null;    
    public BSTIterator(TreeNode root) {
        //initialization baby 
        this.curr = root;
    }

    public int next() {

        while(curr != null){
            if(curr.left == null){
                //point of time of addition bois
                int val = curr.val;
                curr = curr.right;
                return val;
            }else{
                //finding in the left ka atmost right
                var temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    //moving on the right
                    temp = temp.right;
                }
    
                //checking for what came out baby
                //important
                if(temp.right == null){
                    temp.right = curr;
                    //jump in left
                    curr = curr.left;
                }else {
                    temp.right = null;
                    //important position
                    int val = curr.val;
                    //jump in right
                    curr = curr.right;
                    return val;
                }
            } 
        }

        return -1;
    }
    
    public boolean hasNext() {
        return (curr != null);
    }
}
