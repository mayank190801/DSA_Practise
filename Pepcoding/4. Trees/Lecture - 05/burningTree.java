import java.util.*;

import apple.laf.JRSUIUtils.Tree;
import kaway.TreeNode;

public class burningTree{
    public static void main(String[] args) {
        
    }

    void helper(ArrayList<Integer> ans , TreeNode root, int k, TreeNode block){
        if(root == null) return;
        if(root == block) return;

        if(k <= 0){
            if(k == 0)
                ans.add(root.val);
            return;
        }

        helper(ans, root.left, k-1, block);
        helper(ans, root.right, k-1, block);
    }
    
    
     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        help(root, target.val, k, ans);
        return ans;
    }

    public int help(TreeNode root, int data, int k , ArrayList<Integer> ans){
        if(root == null) return -1;

        if(root.val == data){
            helper(ans, root, k, null);
            return 1;
        }

        int left = help(root.left, data, k, ans);
        if(left != -1){
            helper(ans, root, k-left, root.left);
            return left+1;
        }

        int right = help(root.right, data, k, ans);
        if(right != -1){
            helper(ans, root, k-right, root.right);
            return right+1;
        }
    
        return -1;
    }


    //FIRST METHOD 
    //USING K AWAY 
    public List<List<Integer>> burningTree(TreeNode ref, TreeNode root){

        List<List<Integer>> answer = new ArrayList<>();
        int i = 0;
        while(true){
            List<Integer> curr = distanceK(root, ref.val , i++);
            if(curr.size() > 0) answer.add(curr); else break;
        }
    
        return answer;
    }


    //Second method 
    //Without using K away and extra space and shit 
    //NO EXTRA SPACE
    public List<List<Integer>> burningTree(TreeNode ref, TreeNode root){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        burningTree_(ref, root, map);
        List<List<Integer>> ans = new ArrayList<>();
        int st = 0;
        while(map.containsKey(st)){
             ans.add(map.get(st));
             st++;
        }
        return ans;
    }

    public int burningTree_(TreeNode root, TreeNode ref, HashMap<Integer, List<Integer>> map){
        if(root == null) return -1;

        if(root.val == ref.val){
            allDown(ref, map, 0, null);
            return 1;
        }

        int left = burningTree_(root.left, ref, map);
        if(left != -1){
            allDown(root, map, left, root.left);
            return left + 1;
        }

        int right = burningTree_(root.right, ref, map);
        if(right != -1){
            allDown(root, map, right, root.right);
            return right + 1;
        }

        return -1;
    }

    public void allDown(TreeNode root, HashMap<Integer, List<Integer>> map, int time, TreeNode block){
        //now simply add them in map baby
        if(root == null || root == block) return;

        if(!map.containsKey(time)){
            map.put(time, new ArrayList<>());
        }

        map.get(time).add(root.val);

        allDown(root.left, map, time+1, block);
        allDown(root.right, map, time+1, block);
    }

}