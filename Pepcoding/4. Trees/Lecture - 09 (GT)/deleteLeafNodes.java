import java.util.*;

public class deleteLeafNodes {
       
    //node class
    public class Node{
        int val = 0;
        List<Node> children;

        public Node(int val){
            this.val = val;
        }

    }

    //only delete leaf nodes boi
    //POST ORDER FUCKS THIS QUESTION UP
    //only do in preOrder boi
    public Node deleteLeafNode(Node root){

        //just run the loop ulta and you would have no issues
        //simple as that bruh
        for(int i = root.children.size(); i >= 0; i--){
            if(root.children.get(i).children.size() == 0){
                root.children.remove(i);
            }
        }

        for(Node child : root.children){
            deleteLeafNode(child);
        }
    }

    //GENERIC TREE FINISHED
}


