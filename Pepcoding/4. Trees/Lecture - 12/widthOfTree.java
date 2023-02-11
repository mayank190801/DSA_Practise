import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class widthOfTree {

     //DAMN IT DID RUN
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }   
    
    public class pair{
        TreeNode root;
        int state = 0;
        public pair(TreeNode root, int state){
            this.root = root;
            this.state = state;
        }
    }

    //for double ended queue features, use array deque for sure 
    //this is very important my man, always remember that heheheh
    public int widthOfBinaryTree(TreeNode root) {
        //let's solve this baby
        Deque<pair> que = new ArrayDeque<>();
        que.add(new pair(root, 0));
        int ans = 0;
        while(que.size() > 0){
            int size = que.size();
            ans = Math.max(Math.abs(que.getFirst().state - que.getLast().state) + 1, ans);
            while(size -- > 0){
                pair top = que.poll();
                if(top.root.left != null){
                    que.add(new pair(top.root.left, top.state*2 +1));
                }
                if(top.root.right != null){
                    que.add(new pair(top.root.right, top.state*2 +2));
                }
            }
        }

        return ans;        
    }
}
