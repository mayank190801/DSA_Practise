import java.util.*;
import java.io.*;

class LRUCache {

    //let's finish its game once and for all
    int size;
    int capacity;

    //we would need a hashmap to store the addresses of the bullshit
    Map<Integer,ListNode> map;

    //this question requires simple deep thinking 
    //and lot's and lot's of code for sure
    //so the listnode is ready
    public class ListNode{
        int key;
        int value;

        ListNode prev = null;
        ListNode next = null;
        
        ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    ListNode head = null;
    ListNode tail = null;
    //write few function nwo to solve this mess
    public void addFirst(ListNode node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }

        size++;
    }

    //now remove function is very important for this question
    public void removeFirst(){
        //think about this one for now
        //if only one element is there
        if(head.next == null){
            head = null;
            tail = null;
        }else{
            ListNode temp = head.next;
            head.next = null;
            temp.prev = null;
            head = temp;
        }

        size--;
    }

    //these two functions are clear, now we will move forward, and
    //solve this for one
    public void removeLast(){
        if(head.next == null){
            removeFirst();
        }else{
            ListNode temp = tail.prev;
            temp.next = null;
            tail.prev = null;
            tail = temp;
            size--;
        }
    }


    //can you remove the node from dll at any position 
    public void removeNode(ListNode node){

        if(node == null) return;

        ListNode previous = node.prev;
        ListNode forward = node.next;

        if(previous == null){
            removeFirst();
            return;
        }

        if(forward == null){
            removeLast();
            return;
        }

        //now if it lies somewhere in the  middle than do this 
        //pretty simple if you ask me baby
        previous.next = forward;
        forward.prev = previous;

        node.next = null;
        node.prev = null;
        size--;
    }

    //there should be a head and tail ofc
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        //now dll is ready, so we will code this bad boy for our answer
        //we gotta solve this and move on for now, and think about this only
        if(!map.containsKey(key)) return -1;
        //during this phase also we gotta update the values no?
        ListNode pos = map.get(key);
        removeNode(pos);
        addFirst(pos);
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        //everything is about this put function only, everything bruh, how you write this 
        //is what will dictate your future for the rest of your life
        if(map.containsKey(key)){

            //taking the address
            ListNode pos = map.get(key);
            //remove from dll
            removeNode(pos);

            //updating the node value
            pos.value = value;
            //putting it at the first
            addFirst(pos);
        }else{

            if(size == capacity){
                //think about this bad boy
                removeLast();
                map.remove(key);
            }

            ListNode node = new ListNode(key,value);
            map.put(key,node);
            addFirst(node);

            //there could be two option
           
        }
    }
}
