public class BSTtoCircularLinkedList {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        
    }

    //solve this question on your own first, simple as that
    //then remember what sir taught and move on with that question
    //for sure, this is not that hard 

    //This freakin code does work boi
    TreeNode head = null;
    TreeNode tail = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        head = null;
        tail = null;

        if(root == null) return null;
        helper(root);
        head.left = tail;
        tail.right = head;
        return head;
        
    }

    //simple inorder traversal
    //simple as that bad boi
    public void helper(TreeNode root){
        //solve this in here
        if(root == null) return;
        helper(root.left);
        
        //simply add in the linked list
        if(head == null){
            head = root;
            tail = root;
        }else{
            tail.right = root;
            root.left = tail;
            tail = root; 
        }

        helper(root.right);

    }
 
     

}
