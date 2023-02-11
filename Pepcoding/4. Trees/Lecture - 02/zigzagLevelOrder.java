import java.util.*;

import javax.swing.tree.TreeNode;

public class zigzagLevelOrder {
    public static void main(String[] args) {
        
    }

    //pretty good usage of two stacks for sure
    //could be done with que or doublequeue, whatever you want
    //this is easy question, and only implementation is tricky nothing else
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);       
        
        boolean pfltr = true; //put from left tor giht
        while(!st.empty()){
            int size = st.size();
            Stack<TreeNode> help = new Stack<>();
            List<Integer> sans = new ArrayList<>();

            while(size -- > 0){
                TreeNode top = st.pop();
                sans.add(top.val);
                if(pfltr){
                    if(top.left != null)
                        help.push(top.left);

                    if(top.right != null)
                        help.push(top.right);
                }else{
                    if(top.right != null)
                        help.push(top.right);
                    if(top.left != null)
                        help.push(top.left);
                }

            }

            st = help;
            pfltr = !pfltr;
            ans.add(sans);   
        }

        return ans;
    
    }

    
}
