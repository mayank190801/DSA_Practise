import java.util.*;

public class rootToLeafPath{

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
        
    }

    //so this code written by me, does works
    //I am kinda happy about it, it fast and requires top level backtracking
    //he definitely taught us high level backtracking for sure


    //always two types, void and return rememeber that, recursion it is 
    //always two types


    //void types
    public List<String> binaryTreePaths(TreeNode root) {
        //simple as fuck 
        List<String> answer = new ArrayList<>();
        LinkedList<Integer> number = new LinkedList<>();
        binaryTreePaths_(root, answer, number);
        return answer;
    }
    
    public void binaryTreePaths_(TreeNode root, List<String> answer, LinkedList<Integer> number){
        if(root == null) return;

        number.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i : number){
                sb.append(i);
                sb.append("->");
            }
            String ans = sb.substring(0, sb.length()-1).toString();
            answer.add(ans);
            number.removeLast();
            return;
        }

        binaryTreePaths_(root.left, answer, number);
        binaryTreePaths_(root.right, answer, number);
        number.removeLast();
    }

    
}