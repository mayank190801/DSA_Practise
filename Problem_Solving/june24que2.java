import java.util.HashSet;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class june24que2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public static int sum = 0;

    public static int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        helper(root, 1, new int[101]);
        return sum;
    }

    // recursive function will be used
    public static void helper(TreeNode curr, int level, int[] present) {
        if (curr == null)
            return;
        if (present[level] == 1) {
            sum += curr.val;
        }
        if (curr.val % 2 == 0)
            present[level + 2] = 1;
        helper(curr.left, level + 1, present);
        helper(curr.right, level + 1, present);
        present[level + 2] = 0;
    }

}
