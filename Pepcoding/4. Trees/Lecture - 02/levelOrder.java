import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class levelOrder{
    public static void main(String[] args) {
        //just free space baby, no worries for sure. so chill baby
    }

    //level order iterative
    //time O(n)
    //space O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return ans;
    }

    //level order using recursion
    //this actually works perfectly tho, 
    //using level concept with pre/post/in order 
    public List<Integer> levelOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        levelOrderHelper(root, 0, map);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < map.size(); i++){
            ans.add(map.get(i));
        }
        return ans;
    }

    public void levelOrderHelper(TreeNode root, int level, HashMap<Integer, List<Integer>> map){
        if(root == null) return;

        if(!map.containsKey(level)){
            map.put(level, new ArrayList<>());
        }

        map.get(level).add(root.val);

        levelOrderHelper(root.left, level+1, map);
        levelOrderHelper(root.right, level+1, map);

    }

    //now without hashmap, let's try to achieve that for sure now
    //it works perfectly for sure, pretty simple no
    public List<Integer> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderHelper(root, 0, ans);
        return ans;
    }

    public void levelOrderHelper(TreeNode root, int level, List<List<Integer>> ans){
        if(root == null) return;

        if(level == ans.size()){
            ans.add(new ArrayList<>());
        }

        ans.get(level).add(root.val);

        levelOrderHelper(root.left, level+1, ans);
        levelOrderHelper(root.right, level+1, ans);

    }

}