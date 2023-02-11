public class successor{
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

    //SO THIS SHIT WORKED FOR SURE SOMEHOW
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curr = inorderSuccessor_(root, p);
        if(curr == p) return null;
        return curr;
    }

    //SUCCESSOR INORDER WAY
    public TreeNode inorderSuccessor_(TreeNode root, TreeNode p) {
        
        if(root == null) return null;

        if(root == p){
            if(root.right == null){
                return root;
            }else{
                //return right most left, as simple as that boi
                return leftMost(root.right);
            }
        }else if(root.val < p.val){
            TreeNode right = inorderSuccessor_(root.right, p);
            return right;
        }else{
            TreeNode left = inorderSuccessor_(root.left, p);
            if(left != null){
                if(left == p){
                    return root;
                }else{
                    return left;
                }
            }
        }

        return null;
    }

    public TreeNode leftMost(TreeNode root){
        if(root.left == null) return root;
        return leftMost(root.left);
    }

    //-----------------------------------------------------------
    //NOW WE WILL CODE SIR WAY OF SOLVING THIS PROBLEM

    //WITH STATIC VARIABLES AND SHIT
    //INORDER
    TreeNode pred = null;
    TreeNode succ = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        pred = null;
        succ = null;

        inorderSuccessor_(root, p);
        //for this question
        return succ;
    }
    //boolean if found or not is very important in this questio
    //this is successor + predessor for both man!!!
    public TreeNode inorderSuccessor_(TreeNode root, TreeNode p) {

        if(root == null){
            return root;
        }

        if(root.val == p.val){
            //maybe updated in here for sure
            //so update in here baby
            // if(root.left != null){
            //     TreeNode c = root.left;
            //     while(c.right != null){
            //         c = c.right;
            //     }
            //     pred = c;
            // }

            if(root.right != null){
                TreeNode c = root.right;
                while(c.left != null){
                    c = c.left;
                }
                succ = c;
            }

        }else if(root.val < p.val){
            pred = root;
            inorderSuccessor_(root.right, p);
        }else{
            succ = root;
            inorderSuccessor_(root.left, p);
        }

        return root;
    }

    //now solve for without static again for this question
    //PRETTY DOPE FOR SURE
    //We are considering the case where it is definitely present for sure
    public TreeNode inOrderSUccessOrOneCOde(TreeNode root, TreeNode p) { 
        if(root == null){
            return null;
        }

        if(root.val == p.val){
            if(root.right != null){
                TreeNode c = root.right;
                while(c.left != null){
                    c = c.left;
                }
                succ = c;
            }

        }else if(root.val < p.val){
            return inOrderSUccessOrOneCOde(root.right, p);
        }else{
            TreeNode rval = inOrderSUccessOrOneCOde(root.left, p);
            return rval == null ? root : rval;
        }

        return null;
    }

}

//code for ciel and floor is kaafi similar to the top
//no issues on that