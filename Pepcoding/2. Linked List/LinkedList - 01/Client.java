public class Client {
    public static void main(String[] args) {
     
        MyLinkedList list = new MyLinkedList();
        list.addFirst(1);
        list.addLast(3);
        list.addAtIndex(2, 1);
        
        list.display();
    
    }
}
