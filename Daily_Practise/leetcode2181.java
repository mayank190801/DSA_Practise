

public class leetcode2181 {

    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode thead = head;
        ListNode ptr = head;
        ListNode bptr = null;
        while(head != null){
            sum += head.val;
            if(head.val == 0 && sum != 0){
                bptr = ptr;
                ptr.val = sum;
                ptr = ptr.next;
                sum = 0;
            }
            head = head.next;
        }
        bptr.next = null;
        return thead == ptr ? null : thead;
    }








    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
