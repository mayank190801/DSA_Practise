import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class rightView {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //one update, rather than using array for checkig
    //using one static variable
    //minLevel for checking if that level have been achieved yet or not


    //let's do it with recursion first, easy question for sure, let's freakin go man
    //freakin explore trees to their bottom level depth no matter what, and always
    //always keep on doing competitive coding, that's what will take you further ahead
    // public List<Integer> rightSideView(TreeNode root) {
    //     int[] levelTraversed = new int[1000];
    //     List<Integer> answer = new ArrayList<>();
    //     helper(root, 0,levelTraversed, answer);
    //     return answer;
    // }
    
    // //so for some reasons, recursion runs smooth as fuck, no doubt about that, let's figure some iterative way to solve this
    // //it would take some time to solve it and now let's move on and move forward
    // public void helper(TreeNode root, int level, int[] levelTraversed, List<Integer> answer){
    //     if(root == null) return;
        
    //     if(levelTraversed[level] == 0){
    //         answer.add(root.val);
    //         levelTraversed[level] = 1;
    //     }

    //     helper(root.right, level+1, levelTraversed, answer);
    //     helper(root.left, level+1, levelTraversed, answer);
    // }


    //now solve with iterative method down below
    //it did worked bois, so proud of you for sure, i am really really proud on this one 
    public List<Integer> rightSideView(TreeNode root) {
       
        
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;

        //level wise make queue and add the first element in the list, simple as that
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        //this loop will keep going on for sure, until tque is empty
        while(!que.isEmpty()){
            int size = que.size();
           
            boolean first = true;
            while(size -- > 0){
                var node = que.poll();
                if(first) answer.add(node.val);
                first = false;
                if(node.right != null)
                    que.add(node.right);
                
                if(node.left != null)
                    que.add(node.left);
            }
         
        }

        return answer;
    }

}
