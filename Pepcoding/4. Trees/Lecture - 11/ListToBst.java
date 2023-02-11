public class ListToBst {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    
    public static void main(String[] args) {

    }

    //this is beautiful piece of code for sure
    //gotta learn from this asap my man!!!

    //for finding the middle element
    public ListNode mid(ListNode head){
        ListNode s = head;
        ListNode f = head;
        ListNode prev = null;

        //way to find the mid in linkedlist
        //pretty cool for sure
        while(f != null && f.next != null){
            prev = s;
            s = s.next;
            f = f.next.next;
        }

        prev.next = null;
        return s;
    }

    //CREATE BST USING SINGLY LINKEDLIST
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        if(head.next == null){
            return new TreeNode(head.val);
        }

        ListNode mid = mid(head);
        ListNode fhead = mid.next;
        mid.next = null;

        TreeNode root = new TreeNode(mid.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(fhead);

        return root;
    }
    
}
