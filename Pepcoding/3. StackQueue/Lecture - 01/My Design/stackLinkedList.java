public class stackLinkedList{

    class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    int size;
    ListNode head;
    //two functions are necessary for this question
    //add last, remove last

    void addFirst(int val){
        ListNode node = new ListNode(val);
        if(size == 0){
            head = node;
        }else{
            node.next = head;
            head = node;    
        }
        size++;
    }

    int removeFirst(){

        if(size == 0) return -1;

        int ans = head.val;
        ListNode temp = head.next;
        head.next = null;
        head = temp;
        size--;

        return ans;
    }

    //perfect example for this question
    //constructor for the main class and all other functions

    //in this question, you could either make your own linkedlist class
    //or you could have used their inbuilt given class for this purpose
    stackLinkedList(){
        size = 0;
        head = null;
    }

    //two functions for stack baby
    public void push(int val){
        addFirst(val);
    }

    public int pop(){
        return removeFirst();
    }
}