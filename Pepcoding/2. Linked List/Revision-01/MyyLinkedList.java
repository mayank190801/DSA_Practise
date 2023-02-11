public class MyyLinkedList {

    public class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }

        @Override
        public String toString(){
            return val + "";
        }
    }

    ListNode head = null;
    int size = 0;

    //functionalities
    //add first
    public void addFirst(int val){
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
        }else{
            ListNode temp = head;
            head = node;
            node.next = temp;
        }
        size++;
    }

    //add last
    public void addLast(int val){
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
        }else{
            ListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    //get at index
    public int getAtIndex(int idx){
        if(idx >= size || idx < 0){  
            return -1;
        }

        ListNode temp = head;
        while(idx--> 0){
            temp = temp.next;
        }

        return temp.val;
    }

    //add at index
    public void addAtIndex(int val, int idx){   
        if(idx < 0 || idx > size) return;

        if(idx == 0){
            addFirst(val);
        }else if(idx == size){
            addLast(val);
        }else{
            //adding anywhere in the middle should be easy for sure!
            ListNode temp = head;
            while(idx --> 1){
                temp = temp.next;
            }

            ListNode node = new ListNode(val);
            node.next = temp.next;
            temp.next = node;
            size++;
        }

    }

    //remove first
    public int removeFirst(){
        if(size == 0){
            System.out.println("List is Empty!");
            return -1;
        }

        ListNode temp = head;
        head = head.next;
        temp.next = null;

        size--;
        return temp.val;
    }

    //remove last
    public int removeLast(){
        if(size == 0){
            System.out.println("List is Empty!");
            return -1;
        }

        if(size == 1){
            int val = head.val;
            head = null;
            size--;
            return val;
        }

        ListNode temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }

        int val = temp.next.val;
        temp.next = null;
        size--;
        return val;
    }


    //remove at index
    public void removeAtIndex(int idx){
        if(idx < 0 || idx >= size){
            System.out.println("Index is out of range!");
            return;
        }

        if(idx == 0){
            removeFirst();
        }else if(idx == size - 1){
            removeLast();
        }else{
            //somewhere in middle - done!
            ListNode temp = head;
            while(idx --> 1){
                temp = temp.next;
            }

            ListNode temp2 = temp.next.next;
            temp.next.next = null;
            temp.next = temp2;
            size--;
        }
    }


    //display
    public void display(){
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
   
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
