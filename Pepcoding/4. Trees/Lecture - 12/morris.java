import java.util.*;

public class morris{
    
    //morris be smart af
    //MORRIS MEIN INORDER BC
    
    public List<Integer> inOrderMorris(TreeNode node){
        //minor changes done too
        List<Integer> ans = new ArrayList<>();

        while(node != null){
            if(node.left == null){
                //point of time of addition bois
                ans.add(node.val);
                node = node.right;
            }else{
                //finding in the left ka atmost right
                var temp = node.left;
                while(temp.right != null && temp.right != node){
                    //moving on the right
                    temp = temp.right;
                }

                //checking for what came out baby
                //important
                if(temp.right == null){
                    temp.right = node;
                    //jump in left
                    node = node.left;
                }else {
                    temp.right = null;
                    //important position
                    ans.add(node.val);
                    //jump in right
                    node = node.right;
                }
            }
        }
        
        return ans;
    }



}