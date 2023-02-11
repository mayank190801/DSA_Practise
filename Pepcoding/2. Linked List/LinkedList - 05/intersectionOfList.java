public class intersectionOfList {
    //meeting point question

    public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }

    //INTERSECTION POINT CHECK BABY 
    //PROOF DONE IN THE CLASS MATTER A LOT FOR THIS QUEstion for sure
    //THIS COULD BE DONE WITH PROOF ONLY
    //BRILLIANT QUESTION FOR SURE PLEASE WORK ON IT
    public ListNode detectCycle(ListNode head) {
        //now this is the last method for su
        ListNode slow = head;
        ListNode fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }

        if(!cycle) return null;
        slow = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    
}
