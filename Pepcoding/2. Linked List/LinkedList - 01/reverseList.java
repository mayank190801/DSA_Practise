import MyLinkedList.ListNode;

public class reverseList {
    public static void main(String[] args) {
     
        //so we are given the head of nodes
        //i did the iterative method in the morning
        //now i should try recusive one
        //addFirst would be done on a new node
        MyLinkedList list = new MyLinkedList();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        //return a seedhi linked list
        //using addFirst method
        //using iterative
        //using recursion

    }

    //using addFirst()
    // public ListNode reverseList(ListNode head){
    //     ListNode ans = null;
    //     var curr = head;
    //     while(curr != null){
    //         //let's check this one, and solve this problem
    //         ListNode f = curr.next;
    //         curr.next = null;
    //         ans = addFirst(ans ,curr);
    //         curr = f;
    //     }
    //     return ans;
    // }

    // public ListNode addFirst(ListNode ans, ListNode node){
    //     if(ans == null){
    //         return node;
    //     }else if(
    //         node.next = ans;
    //         return node;
    //     )
    // }


    //using iterative
    // public ListNode reverseList(ListNode head){ 
    //     if(head == null){
    //         return head;
    //     }
        
    //     if(head.next == null){
    //         return head;
    //     }
            
    //     ListNode post = null;
    //     ListNode curr = head;
    //     ListNode pre = head.next;
        
    //     while(pre != null){
    //         curr.next = post;
    //         post = curr;
    //         curr = pre;
    //         pre = pre.next;
    //     }
        
    //     curr.next = post;
    //     head = curr;
    //     return head;
    // }

    //using recursion
    // public ListNode reverseList(ListNode head){
        
    //     if(head == null){
    //         return null;
    //     }
        
    //     if(head.next == null){
    //         return head;
    //     }
        
    //     //recursion is the sexiest
    //     var temp = head.next;
    //     var tempHead = reverseList(head.next);
    //     head.next = null;
    //     temp.next= head;
    //     return tempHead;
        
    // }
    

}
