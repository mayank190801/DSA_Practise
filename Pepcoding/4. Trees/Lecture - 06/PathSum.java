import java.util.*;

public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        //all code worked tho, i am too happy for this world
        //i can code mtlb if i want to, and i focus myself into this 
        //coding is fun and i love it 
        //i am good at typing either, i may be a worker, but highly paid worker for sure
        //someone so so so rich, that no one defines the value of it
        //and build my empire then
    }

    //path sum1
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0) return true;
            return false;
        }

        boolean res = false;
        res = res || hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum- root.val);
        return res;
    }

    //path sum2
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> number = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        helper(root, answer, number, targetSum);
        return answer;
    }

    public void helper(TreeNode root, List<List<Integer>> answer, LinkedList<Integer> number, int targetSum){
        if(root == null) return;

        number.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum -  root.val == 0){
                //such important part tho, always remember about this guy
                //deep copy and shallow copy baby
                LinkedList<Integer> copy = new LinkedList<>(number);
                answer.add(copy);
            }
            number.removeLast();
            return;
        }

        helper(root.left, answer, number, targetSum - root.val);
        helper(root.right, answer, number, targetSum - root.val);
        number.removeLast();
    }

    //Path sum3 is also here bois
    //for sum fuck sake reasons, this code worked out too
    //I am kinda proud of my logical building 
    //O(n^2) method is used in here
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        
        int count = 0;
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        
        if(targetSum-root.val == 0) count += 1;
        
        count += helper(root.left, targetSum- root.val);
        count += helper(root.right, targetSum - root.val);

        return count;
    }

    public int helper(TreeNode root, int targetSum) {
        if(root == null) return 0;
    
        int count = 0;
        if(targetSum-root.val == 0) count += 1;

        count += helper(root.left, targetSum - root.val);
        count += helper(root.right, targetSum- root.val);
        return count;
    }

    //PATH SUM3 
    //Hashmap and better version of sir method
    //this bad boy runs in 5 ms only bitches
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        return pathSum_(root, targetSum, 0, map);
    }

    public int pathSum_(TreeNode root, int tar, int sum, HashMap<Integer,Integer> map){
        if(root == null) return 0;
        sum += root.val;
        int count = 0;
        if(map.containsKey(sum - tar)){
            count += map.get(sum - tar);
        }

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        count += pathSum_(root.left, tar, sum, map);
        count += pathSum_(root.right, tar, sum, map);

        map.put(sum, map.get(sum) -1);
        return count;
    }
}
