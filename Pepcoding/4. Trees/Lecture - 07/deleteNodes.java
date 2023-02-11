import java.util.*;

import flattenTree.TreeNode;

public class deleteNodes {
    public static void main(String[] args) {
        
    }
    
    //MY WAY OF SOLVING THIS BAD BOY

    //return the treenode from head
    //this code does work tho boi
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> answer = new ArrayList<>();
        int[] arr = new int[1001];
        for(int i : to_delete){
            arr[i] = 1;
        }
          
        if(arr[root.val] == 0) answer.add(root);
          
        helper(root, arr, answer);
        return answer;
    }

    //definitely need helper function 
    //let's solve this bad boi
    //start using return type for more of your help, and think is post order
    public TreeNode helper(TreeNode root, int[] arr, List<TreeNode> answer){
        if(root == null) return null;
        
        root.left = helper(root.left, arr, answer);
        root.right = helper(root.right, arr, answer);

        if(arr[root.val] == 1){
            if(root.left != null && arr[root.left.val] == 0){
                answer.add(root.left);
            }

            if(root.right != null && arr[root.right.val] == 0){
                answer.add(root.right);
            }

            return null;
        }

        return root;
    
    }

    //We will also write sir version of code for this bad boi, try solving on your own
    //ease as fuck
    //DELETE NODES AND RETURN FOREST
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : to_delete){
            set.add(ele);
        }
        List<TreeNode> ans = new ArrayList<>();
        delNodes_(root, set, ans);
        if(!set.contains(root.val)){
            ans.add(root);
        }
        return ans;
    }

    public TreeNode delNodes_(TreeNode root, HashSet<Integer> set, List<TreeNode> ans){
        if(root == null) return root;

        root.left = delNodes_(root.left, set, ans);
        root.right = delNodes_(root.right, set, ans);

        //working in post order, so don't need to check baby
        //very crucial evidence to figure that out
        //think more deeply in post order for sure now
        if(set.contains(root.val)){
            if(root.left != null)
                ans.add(root.left);

            if(root.right != null)
                ans.add(root.right);

            return null;
        }

        return root;
    }

}
