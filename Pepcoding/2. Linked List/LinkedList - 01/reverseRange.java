import MyLinkedList.ListNode;

public class reverseRange {

    ListNode th = null, tt = null;
    //this method is way too fancy no?
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode p = d;
        ListNode c = d.next;

        //in one sinle loop, this is how you do it
        //damn this code is sizzling for sure
        //scary as fuck man
        //simple and steady
        int i = 1;
        while(true){
            //if i is equals to left
            //middle range
            while(i >= left && i <= right){
                //addFirst is like the OP method in here
                //brilaint piece of code
                ListNode f = c.next;
                c.next = null;
                th = addFirst(th, tt, c);
                c = c.next;
                i++;
            }

            //right range
            if(i > right){
                p.next = th;
                tt.next = c;
                break;
            }
            
            //simle shit, but gotta try it on your own for god sake
            //left range
            p = c;
            c = c.next;
            i++;
        }
    }

    //reverse list in this way is best thing to do
    public void addFirst(ListNode th, ListNode tt, ListNode c){
        
        if(th == null){
            th = c;
            tt = c;
        }else{
            c.next = th;
            th = c;
        }
    }

    //this below is my code and works beautifully
    // public ListNode reverseBetween(ListNode head, int left, int right) {
        
    //     //simple as that
    //     ListNode dummy = new ListNode(3);
    //     dummy.next = head;
    //     head = dummy;

    //     var p = head;
    //     var q = head;
    //     var r = head;
    //     var s = head;

    //     //this much i was able to retrieve let's move further and reverse this linked list
    //     //once and for all, no doubts or shits should be left now to be worked upon
    //     while(left--> 1){
    //         p = p.next;
    //     }
    //     q = p.next;
    //     while(right--> 0){
    //         r = r.next;
    //     }
    //     s = r.next;
        

    //     var past = p;
    //     var curr = q;
    //     var fut = q.next;

    //     while(curr != s){
    //         curr.next = past;
    //         past = curr;
    //         curr = fut;
    //         fut = fut.next;
    //     }        

    //     p.next = r;
    //     q.next = s;

    //     var temp = head.next;
    //     head.next = null;
    //     return temp;

    // }
}
