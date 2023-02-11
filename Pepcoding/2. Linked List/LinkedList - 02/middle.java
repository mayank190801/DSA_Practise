public class middle {
    public static void main(String[] args) {
        
    }

    //definetly better way of coding
    //divide in index based and size based
    //sir version is coolest for sure
    //index > f.n && f.n.n
    //sized > f && f.n
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        return slow;
    }

    //middleNode shit
    //my way of coding
    //let's check sir way of doing baby
    public ListNode middleNode(ListNode head) {
        //return the middle node
        ListNode slow = head;
        ListNode fast = head;

      
        while(fast != null){
            if(fast.next == null){
                return slow;
            }

            if(fast.next.next == null){
                return slow.next;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
  
    }
}
