import java.util.ArrayList;
import java.util.Queue;

public class leftView {
    //now doing the same for rightView simple as that, not very hard task, simple 
    //simple as fuck, from now on we will have lectures, and i could speed my process up
    //multiple times for sure
    public class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

   
    //so recursion is the easiest for sure, and it does work
    // public ArrayList<Integer> leftView(Node root) {
    //     int[] levelTraversed = new int[1000];
    //     ArrayList<Integer> answer = new ArrayList<>();
    //     helper(root, 0,levelTraversed, answer);
    //     return answer;
    // }
    
    // //so for some reasons, recursion runs smooth as fuck, no doubt about that, let's figure some iterative way to solve this
    // //it would take some time to solve it and now let's move on and move forward
    // public void helper(Node root, int level, int[] levelTraversed, ArrayList<Integer> answer){
    //     if(root == null) return;
        
    //     if(levelTraversed[level] == 0){
    //         answer.add(root.val);
    //         levelTraversed[level] = 1;
    //     }

    //     helper(root.left, level+1, levelTraversed, answer);
    //     helper(root.right, level+1, levelTraversed, answer);
    // }

        //some little improvements in code for sure
        //every time i right it, there is some improvements in it for sure
        //trees can be optimised to ultimate levels for sure
    public ArrayList<Integer> leftView(TreeNode root) {
       
        
        ArrayList<Integer> answer = new ArrayList<>();
        if(root == null) return answer;

        //level wise make queue and add the first element in the list, simple as that
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);

        //this loop will keep going on for sure, until tque is empty
        while(!que.isEmpty()){
            int size = que.size();
            
            var node = que.peek();
            answer.add(node.data);
            
            while(size -- > 0){
                var node = que.poll();
                
                if(node.left != null)
                    que.add(node.left);

                if(node.right != null)
                    que.add(node.right);
            }
         
        }

        return answer;
    }
    
}
