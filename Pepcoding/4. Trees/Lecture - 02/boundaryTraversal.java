import java.util.ArrayList;

public class boundaryTraversal {
    public static void main(String[] args) {
        
    }

    //main solve
    //brilliant piece of code for sure, i love it 
    //this code is hard to remember but easy to implement for for for for for sure
    //not something impossible
    //place hone ke liye ni bethe kya???
    public  List<Integer> boundaryOfTree(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        leftBoundary(root.left, ans);
        //i did it perfectly for sure, hehehehe, i am smart
        leaves(root.left, ans);
        leaves(root.right, ans);
        //this one in reverse is imoprtant
        rightBoundary(root.right, ans);
    }

    //let's solve this one for sure now
    public void rightBoundary(TreeNode root, List<Integer> ans){
        if(root == null || (root.left == null && root.right == null)) return;

        if(root.right != null){
            rightBoundary(root.right, ans);
        }else{
            rightBoundary(root.left, ans);
        }
        //why post order? cause we want tin reverse baby
        ans.add(root.val);
    }

    public void leftBoundary(TreeNode root, List<Integer> ans){
        if(root == null || (root.left == null && root.right == null)) return;

        ans.add(root.val);
        if(root.left != null){
            leftBoundary(root.left, ans);
        }else{
            leftBoundary(root.right, ans);
        }
    }

    //now figure out leaves too boi
    //some order is there and that's prett easy for sure
    public void leaves(TreeNode root, List<Integer> ans){

        if(root == null) return;

        if(root.left == null && root.right == null){
            ans.add(root.val);
            return;
        }

        leaves(root.left, ans);
        leaves(root.right, ans);
    }

}
