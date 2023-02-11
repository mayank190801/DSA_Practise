import java.util.*;

public class flatten {
    public static void main(String[] args) {
        
    }

    //node class
    public class Node{
        int val = 0;
        List<Node> children;

        public Node(int val){
            this.val = val;
        }

    }

    //just a change in the way of code
    public Node flattenTree(Node root){

        if(root.children.size() == 0){
            return root;
        }

        List<Node> tail = new ArrayList<>();
        
        //save all tails in here
        for(Node child : root.children){
            Node ctail = flattenTree(child);
            tail.add(ctail);
        }

        //this loop has some limits!! Always remember that boi
        for(int i = root.children.size() -1; i > 0; i--){
            Node last = root.children.get(i);
            //this is important boi
            root.children.remove(root.children.size()-1);

            //getTail of i-1th element
            Node ctail = tail.get(i-1);
            ctail.children.add(last);
        }

        return tail.get(tail.size()-1);
    }

}
