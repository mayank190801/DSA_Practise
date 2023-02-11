import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

public class RandomPointer {
    public static void main(String[] args) {
        //so both of my code ran perfectly, without more than 1-2 errors
        //so i should definitely practise my java implementation part
        //if i get super good at it, and very very efficient, then it would be a win
        //that would change my way of coding
    
    }

    //now using the second beast method, this method is actually really crazy
    //you gotta look at this method for sure my boy, for sure
    //first we make copy of every element and insert it in the list, next we 
    //point the random pointer to destined positions
    //third we gotta unfold our nodes, connect them and return the list 
    //it will do the thing for sure

    //i gotta practise a lot of questions today, let's practise them diligently for sure
    //no give up or nothing, plain hardcore mode for sure
    public Node copyRandomList(Node head){

        //try to keep this code in functions format, so that you would know which part of the code failed 
        //try to always keep your code in different functions

        Node curr =head;
        while(curr != null){
            Node copy = new Node(curr.val);
            Node temp = curr.next;
            curr.next = copy;
            copy.next = temp;
            curr = temp;

            //and move on for the rest of the game
        }

        //by now it will look something like this 
        //1 1 2 2 3 3 4 4 5 5
        curr = head;
        //i will again run this loop for surety that this code runs
        //for and one and for all, this time, it would be pretty good
        while(curr != null){
            Node random = curr.random;
            Node copy = curr.next;
            if(random != null){
                Node crandom = random.next;
                copy.random = crandom;
            }

            curr = curr.next.next;
        }

        //now i gotta remove these nodes and shit, we gotta seperate them
        Node d = new Node(-1);
        Node pointer = d;
        curr = head;
        while(curr != null){
            Node copy = curr.next;
            curr.next = copy.next;
            curr = curr.next;

            pointer.next = copy;
            copy.next = null;
            pointer = copy;
        }

        return d.next;
    }

    //first method is using hashmap, and that's really boring 
    //but we gotta code for it sure
    // public Node copyRandomList(Node head) {
        
    //     Node d = new Node(-1);
    //     Node pointer = d;

    //     //not a problem
    //     Map<Node,Node> map = new HashMap<>();
    //     Node curr = head;

    //     //one looping for initializing everything and setting random pointer
    //     while(curr != null){
    //         int val = curr.val;
    //         Node copy =  new Node(val);

    //         map.put(curr, copy);
    //         pointer.next = copy;
    //         pointer = copy;
    //         curr = curr.next;
    //     }

    //     //now for the next loop we gotta figure some stuff out
    //     //what we gottdo 

    //     curr = head;
    //     pointer = d;
    //     while(curr != null){    
    //         Node random = curr.random;
    //         pointer = pointer.next;
    //         curr = curr.next;

    //         if(random != null){
    //             Node crandom = map.get(random);
    //             pointer.random = crandom;
    //         }
    //     }

    //     return d.next;
    // }
    
}
