public class palindrome {
    public static void main(String[] args) {
        
    }

    public ListNode mid(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next.next != null || fast.next != null){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head){
        //just a lil trick, that is make only forw only when needed
        ListNode curr = head, prev = null, forw = null;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;

            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        //first go to the center node
        //so now we will have the appropriate way
        ListNode m = mid(head);
        ListNode fhead = m.next;
        m.next = null;

        ListNode nhead = reverse(fhead);
        //now we have the reverse list head and the normal list head
        ListNode p1 = head, p2 = nhead;

        //so the code was ofc was success, but we don't want to destroy the linkedList once it's created
        //so we will try to make some changes in it, and go for the best version of the solution
        boolean flag = true;
        while(p1 != null & p2 != null){
            if(p1.val != p2.val){
                flag = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }   

        //makes some sense for sure
        m.next = reverse(nhead);
        return flag;
    }

    //this was sir logic and i would want to think of my own
    //check , breaking and atlast back to fixing palindrome should be done
    public boolean isPalindrome(ListNode head) {
        ListNode m = mid(head);
        ListNode fhead = m.next;
        m.next = null;
        fhead = reverseList(fhead);
        ListNode p1 = head;
        ListNode p2 = fhead;
        
        while(p1 != null && p2 != null){
            if(p1.val != p2.val){
                return false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

}
