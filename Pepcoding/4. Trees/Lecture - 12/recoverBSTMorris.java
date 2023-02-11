public class recoverBSTMorris {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    //The only change in the sir code is that, he have explicitly prev = curr
    // in the if's loop as well as pretty similar logic in my version and sir's
    

    //next time se we will be working on hashmap and shit bois
    //It does work bois
    //Congo congo congo congo congo congo congo congo congo congo congo
    public void recoverTree(TreeNode root) {
        TreeNode node = root;
        //let's figure those two nodes which are being swapped in their
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;

        while(node != null){
            if(node.left == null){
                //point of time of addition bois
                //make few checks in here to game change this question
                if(first == null){
                    if( prev != null && prev.val > node.val){
                        first = prev;
                        second = node;
                    }
                }else{
                    if(prev.val > node.val){
                        second = node;
                    }
                }

                prev = node;
                node = node.right;
            }else{
                //finding in the left ka atmost right
                TreeNode temp = node.left;
                while(temp.right != null && temp.right != node){
                    //moving on the right
                    temp = temp.right;
                }

                //checking for what came out baby
                //important
                if(temp.right == null){
                    temp.right = node;
                    //jump in left
                    prev = node;
                    node = node.left;
                }else {
                    temp.right = null;
                    //important position
                    if(first == null){
                        if(prev != null && prev.val > node.val){
                            first = prev;
                            second = node;
                        }
                    }else{
                        if(prev.val > node.val){
                            second = node;
                        }
                    }
                    //jump in right
                    //how to set prev
                    prev = node;
                    node = node.right;
                }
            }
        }
        
        //change the values of first and second
        if(first != null && second != null){
            int val = first.val;
            first.val = second.val;
            second.val = val;
        }
    }

}
