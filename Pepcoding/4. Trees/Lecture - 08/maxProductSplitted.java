import java.util.ArrayDeque;
import java.util.Queue;

public class maxProductSplitted {
    public static void main(String[] args) {
        
    }
    //ITS DONE
    //YOU COULD HAVE USED SUM IN THE FUNCTION ONLY
    //THAT'S IT
    //COULD BE CONVERTED TO WITHOUT STATIC THAT'S UPTO YOU 

    long max = 0;
    long sum = 0;
    long modulo = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        //some shit to organis
        sum = 0;
        max = 0;

        sum = sum_(root);
        long temp = maxProduct_(root);
        return (int)(max%modulo);
    }

    //finding the sum
    public long sum_(TreeNode root){
        //can't do it in recursive fashion hehe
        if(root == null) return 0;

        long l = sum_(root.left);
        long r = sum_(root.right);

        return l + r + root.val;
    }

    public long maxProduct_(TreeNode root){

        if(root == null) return 0;

        long left = maxProduct_(root.left);
        long right = maxProduct_(root.right);

        max = Math.max(left * (sum - left), max);
        max = Math.max(right * (sum - right), max);

        return left + right + root.val;
    }

    
    
}
