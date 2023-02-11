public class queueLinkedList{

    class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    int size;
    ListNode head;
    ListNode tail;
    //two functions are necessary for this question
    //add last, remove last

    void addLast(int val){
        ListNode node = new ListNode(val);
        if(size == 0){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;    
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


    //starting of the main class for your knowledge dude
    //this where we would know things exist

    //in this question, you could either make your own linkedlist class
    //or you could have used their inbuilt given class for this purpose
    queueLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }

    //two functions for stack baby
    public void enqueue(int val){
        addLast(val);
    }

    public int dequeue(){
        return removeFirst();
    }
}