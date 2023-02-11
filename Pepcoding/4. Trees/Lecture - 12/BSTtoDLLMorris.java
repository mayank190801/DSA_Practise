import java.util.ArrayList;
import java.util.List;

public class BSTtoDLLMorris {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    //let's figure this out
    //This kinda works too boi
    public TreeNode treeToDoublyList(TreeNode root) {
        //Try writing morris inorder on your own brother
        if(root == null) return null;
        
        //simple morris inorder traversal bois
        //simple as fuck, could use class and shit, but this is better bois
        TreeNode head = null;
        TreeNode tail = null;

        while(root != null){
            if(root.left == null){
                if(head == null){
                    head = tail = root;
                }else{
                    tail.right = root;
                    root.left = tail;
                    tail = root;
                }
                root = root.right;
            }else{
                //make a temp variable
                TreeNode temp = root.left;

                while(temp.right != null && temp.right != root){
                    temp = temp.right;
                }

                if(temp.right == null){
                    temp.right = root;
                    root = root.left;
                }else{
                    temp.right = null;
                    //jump somewhere else
                    if(head == null){
                        head = tail = root;
                    }else{
                        tail.right = root;
                        root.left = tail;
                        tail = root;
                    }
                    
                    root = root.right;
                }
            }
        }

        head.left = tail;
        tail.right = head;
        return head;

    }

    


}
