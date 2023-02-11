public class findingCycle {

    public static class Node{
        int val;
        Node next;

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    //Space Complexity O(1)
    //Time Complexity - O(n)


    public static boolean findCycle(Node head){
        if(head == null) return false;

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){  //later stage
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }


}
