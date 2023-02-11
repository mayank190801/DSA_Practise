import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class path {
    public static void main(String[] args) {
        
    }
    
    public static class Node {
        int data;
        Node left;
        Node right;
        Node() {}
        Node(int data) { this.data = data; }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    //min max size height all solution for this code
    //basic functions for trees
    //find code for trees

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int size = 0;
    int height = 0;

    //recursive solutions baby
    //what i wrote for this piece of shit
    //two paragraphs shit
    public int minTree(Node root){
        helperMin(root);
        return min;
    }

    public void helperMin(Node node){   
        if(node == null) return;
        min = Math.min(min, node.data);
        helperMin(node.left);
        helperMin(node.right);
    }

    //where as you could have used something superb 
    //this is what sir wrote, in just three lines baby

    //min
    public int min(Node root){
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(Math.min(min(root.left), min(root.right)), root.data);
    }

    //max
    public int max(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(Math.max(max(root.left), max(root.right)), root.data);
    }

    //size
    public int size(Node root){
        if(root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }

    //height 
    public int height(Node root){
        if(root == null) return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }

    //find 
    //simple sober three lines of code
    //my way of doing things but but but you aint's gotta do it like that 
    public boolean find(Node root, int search){
        if(root == null) return false;
        if(root.data == search) return true;
        return find(root.left, search) || find(root.right, search);
    }

    public  boolean findd(Node root, int data){
        if(root == null ) return false;
        if(root.data == data) return true;

        //more advanced way of doing things is pretty cool
        boolean res = false;
        //seedha bhaag jaayega root ki taraf, zyada idhar udhar ni dekhega
        //pretty dope to learn this way
        res = res || findd(root.left, data) || findd(root.right, data);
        return res;
    }

    //root to node path question
    //ROOT TO NODE

    //my version of the code for this question 
    //let's see sir version later on 
    // public List<Node> rootToNodePath(Node root, int data){
    //     //try to code in on your own    
    //     LinkedList<Node> path = new LinkedList<>();
    //     helper(root, path, data);
    //     return path;
    // }

    // public boolean helper(Node root, LinkedList<Node> path, int data){
    //     //let's write this piece of code for now, and let's learn
    //     if(root == null) return false;
        
    //     path.addLast(root);

    //     if(root.data == data) return true;
    //     boolean res = false;
    //     res = res || helper(root.left, path, data) || helper(root.right, path, data);

    //     if(!res) path.removeLast();
    //     return res;
    // }


    //SIR VERSION
    //TRUE RECURSION CODE ARTIST FOR SURE
    public List<Node> rootToNodePath(Node root, int data){

        //null case bitch
        if(root == null){
            return new ArrayList<>();
        }

        //base case
        if(root.data == data){
            List<Node> base = new ArrayList<>();
            base.add(root);
            return base;
        }

        List<Node> left = rootToNodePath(root.left, data);
        //we would know if we got answer from left or not
        if(left.size() > 0){
            left.add(root);
            return left;
        }

        List<Node> right = rootToNodePath(root.right, data);
        if(right.size() > 0){
            right.add(root);
            return right;
        }

        return new ArrayList<>();
    }

    //ROOT TO NODE DISTANCE

    //just convert upper form into int only, simple as taht
    public int rootToNodeDistance(Node root, int data){

        //null case bitch
        if(root == null)return -1;

        //base case
        if(root.data == data) return 1;

        int left = rootToNodeDistance(root.left, data);
        //we would know if we got answer from left or not
        if(left != -1) return left+1;
        
        int right = rootToNodeDistance(root.right, data);
        if(right != -1) return right+1;        

        return -1;
    }

    //lca later on bitches dude
    //diameter and shit to be known for this 
    //we have to find the nearest leaf node bitches
    //my version of code, and definitely works dude
}
