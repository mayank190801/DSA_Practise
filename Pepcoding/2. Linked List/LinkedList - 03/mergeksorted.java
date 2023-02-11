public class mergeksorted {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        //using binary search this time, let's see how i can solve it
        //first divide it into two parts
        //send both of them to mergeKList and then return them back
        //and apply merge2sort on both of them
        //and then return that piece of shit
        //i would need helper function for sure , for this type of work, ngl
        ListNode head = mergeKList(lists, 0, lists.length-1);
        return head;
    }

    public ListNode mergeKList(ListNode[] lists, int s, int e){
        //think about this solve for now
        if(s == e){
            return lists[s];
        }

        int mid = (s+e)/2;
        Node left = mergeKList(lists, s, mid);
        Node right = mergeKList(lists, mid+1, e);

        Node nhead = mergeTwoLists(left, right);
        return nhead;
    }


    //so this was the second method, that is linear merge and linear search type of question
    //pretty decent to work with for sure, let's see how it goes, and idk what to do!

    // public ListNode mergeKLists(ListNode[] lists) {
    //     ListNode dummy = new ListNode(-100000000);
    //     //that's the values

    //     for(int i = 0; i < lists.length; i++){
    //         if(lists[i] != null){
    //             dummy = mergeTwoLists(dummy, lists[i]);
    //         }
    //     }

    //     return dummy.next;

    // }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(-1);
        ListNode c = d, c1 = l1, c2 = l2;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                c.next = c1;
                c1 = c1.next;
            } else {
                c.next = c2;
                c2 = c2.next;
            }
            c = c.next;
        }
        if (c1 == null) {
            c.next = c2;
        } else {
            c.next = c1;
        }
        return d.next;
    }






    //This below is one method to solve this question
    //And it's realy damn damn damn cool, to solve this one for sure!
    //I actually loved it, idk about you guys

    // public ListNode getTail(ListNode head){
    //     ListNode curr = head;
    //     while(curr.next != null){
    //         curr = curr.next;
    //     }
    //     return curr;
    // }

    // public ListNode mid(ListNode head){
    //     ListNode slow = head;
    //     ListNode fast = head;

    //     while(fast.next != null && fast.next.next != null){
    //         slow = slow.next;
    //         fast = fast.next;
    //         fast = fast.next;
    //     }

    //     return slow;
    // }
    
    // public ListNode sortList(ListNode head) {

    //     if( head == null || head.next == null ){
    //         return head;
    //     }

    //     ListNode mid = mid(head);
    //     ListNode second = mid.next;
    //     mid.next = null;

    //     head = sortList(head);
    //     second = sortList(second);

    //     //now compare the nodes
    //     //now both are sorted, you have to simply use merge 2 sorted shit
    //     return  mergeTwoLists(head, second);

    // }

    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    //     ListNode d = new ListNode(-1);
    //     ListNode c = d;

    //     while(l1 != null && l2 != null){
    //         if(l1.val <= l2.val){
    //             c.next = l1;
    //             l1 = l1.next;
    //             c = c.next;
    //             c.next = null;
    //         }else{
    //             c.next = l2;
    //             l2 = l2.next;
    //             c = c.next;
    //             c.next = null;
    //         }
    //     }

    //     if(l1 != null){
    //         c.next = l1;
    //     }

    //     if(l2 != null){
    //         c.next = l2;
    //     }

    //     return d.next;
    // }

    // public ListNode mergeKLists(ListNode[] lists) {
        
    //     //i have to simply merge these array into one first

    //     ListNode curr = null;
    //     ListNode thead = null;

    //     int i = 0;
    //     for( i= 0; i < lists.length; i++){
    //         if(lists[i] != null){
    //             curr = lists[i];
    //             thead = lists[i];
    //             break;
    //         }
    //     }
        

    //     for( ; i < lists.length ; i++){
    //         if(lists[i] != null){
    //             ListNode tail = getTail(curr);
    //             tail.next = lists[i];        
    //             curr = lists[i];
    //         }
    //     }

    //     mergesort(thead);
    
    // }

    
}
