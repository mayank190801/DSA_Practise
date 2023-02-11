import java.util.ArrayDeque;
import java.util.Queue;

public class completeBinaryTreeInserter {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //this code worked, yippeeeee
    //i am pretty brilliant tbh at times

    //much faster for sure
    class CBTInserter {
        Queue<TreeNode> queue;
        TreeNode head = null;

        public CBTInserter(TreeNode root) {
            queue = new ArrayDeque<>();
            //traverse and all of them in there
            //some long ass function tbh
            Queue<TreeNode> current = new ArrayDeque<>();
            current.add(root);
            while(!current.isEmpty()){
                int size = current.size();
                while(size --> 0){
                    TreeNode curr = current.poll();
                    queue.add(curr);

                    if(curr.left != null){
                        current.add(curr.left);
                    }

                    if(curr.right != null){
                        current.add(curr.right);
                    }
                }
            }
            head = root;

            TreeNode top = queue.peek();
            while(top.left != null && top.right != null){
                queue.poll();
                top = queue.peek();
            }
        }
        
        public int insert(int val) {
            TreeNode top = queue.peek();
            TreeNode node = new TreeNode(val);
            queue.add(node);

            if(top.left == null){
                top.left = node;
                return top.val;
            }   

            top.right = node;
            queue.poll();
            return top.val;
        }
        
        public TreeNode get_root() {
            return head;
        }
    }
    
}
