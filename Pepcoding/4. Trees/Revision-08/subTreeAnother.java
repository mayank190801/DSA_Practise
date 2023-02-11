
//now let's imagine solving this problem no matter what for sure
class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        
    }

    //ek identical tree bhi bnana hai for sure
    public void identical_(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        if(root.val != subRoot.val) return false;
        return identical_()
    }

    //equal trees logic 
    public void helper_(TreeNode root, TreeNode subRoot){
    	if(root == null && subRoot == null) return true;
    	if(root == null || subRoot == null) return false;

        //check if the answer is exist for left or right



    	//now for the current one
        boolean left = helper_(root.left, subRoot.left);
        boolean right = helper_(root.)


        if(root.val != subRoot.val) 




    }

}