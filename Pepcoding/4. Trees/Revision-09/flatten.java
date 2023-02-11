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

    	//root ke saare childs ka tail laao simple
    	//head to hai hi mere paas simple
    	List<Node> children = root.children;
    	root.children = new ArrayList<>();

    	List<Node> tails = new ArrayList<>();
    	for(int i = 0; i < children.size(); i++){
    		Node tail = flattenTree(children.get(i));
    		tails.add(tail);
    	}

    	//settle them properly for sure
    	Node head = root;
    	for(int i = 0; i < tails.size(); i++){
    		Node tail = tails.get(i);
    		root.children.add(children.get(i));
    		children.get(i).add(tail);

    	}
    	



    }

}
