import java.util.ArrayList;
import java.util.List;

public class RecursiveTraversals{
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

    }

    //O(n)
    //O(logn)

    public List<Integer> preOrder(TreeNode node){
        if(node == null){
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        List<Integer> left = preOrder(node.left);
        List<Integer> right = preOrder(node.right);

        ans.add(node.val);
        ans.addAll(left);
        ans.addAll(right);
    }

    public List<Integer> inOrder(TreeNode node){
        if(node == null){
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        List<Integer> left = inOrder(node.left);
        List<Integer> right = inOrder(node.right);

        ans.addAll(left);
        ans.add(node.val);
        ans.addAll(right);
    }

    public List<Integer> postOrder(TreeNode node){
        if(node == null){
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        List<Integer> left = postOrder(node.left);
        List<Integer> right = postOrder(node.right);

        ans.addAll(left);
        ans.addAll(right);
        ans.add(node.val);
    }
}