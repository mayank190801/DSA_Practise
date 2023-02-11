import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class levelOrderBottomUp {

    public static void main(String[] args) {
        
    }

    //this shit worked for this question, let's see what modifications sir would be able to do
    //let's figure this out for sure now
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> sans = new LinkedList<>();
            while(size -->0){
                TreeNode top = que.poll();
                sans.add(top.val);

                //now add left and right child to que
                if(top.left != null) que.add(top.left); 
                if(top.right != null) que.add(top.right);
            }
            ans.add(sans);
        }

        //just simple as that bitch
        Collections.reverse(ans);
        return newAns;
    }
    
}
