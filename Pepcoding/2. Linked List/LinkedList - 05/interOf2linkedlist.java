public class interOf2linkedlist {

    public int sizeNode(ListNode head){

        int size = 0;
        while(head != null){
            head = head.next;
            size++;
        }

        return size;
    }

    //size method for this question
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //a lot of edge cases would be there so be ready to solve them
        if(headA == null || headB == null){
            return null;
        }

        int asize = sizeNode(headA);
        int bsize = sizeNode(headB);

        //now figure out what else you can do
        ListNode s1 = headA;
        ListNode s2 = headB;
        int diff = Math.abs(bsize-asize);
        
        //this one is what i did on my own
        //so it may have some confusing if else logic for sure
        //if i can think and make it better for the reader, than that would be 
        //way lot better for the solve
        if(bsize > asize){
            while(diff -->0){
                s2 = s2.next;
            }
        }else{
            while(diff --> 0){
                s1 = s1.next;
            }
        }

        while(s1 != null && s2 != null){
            if(s1 == s2) return s1;
            s1 = s1.next;
            s2 = s2.next;
        }

        return null;
    }

    //cycle method for this question
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curr = headA;
        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = headB;

        //why start from headA is very important 
        //headB is inside the cycle and fast and slow will always end up at the same spot
        //again and agian for sure, that is also way too annoying 
        ListNode answer = detectCycle(headA);

        curr.next = null;
        return answer;
    }


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
