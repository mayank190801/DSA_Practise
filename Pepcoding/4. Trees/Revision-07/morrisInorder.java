class Solution {
    
	
	//iterative solution for this would be crazy for sure!! 
   	public void flatten(TreeNode root) {
   		//root is not null hopefully
   		if(root == null) return null;


   		TreeNode curr = root;
   		while(curr != null){
	   		if(curr.left == null){
	   			//can't do anything at this point

	   			curr = curr.right;
	   		}else{

	   			TreeNode temp = curr.left;
	   			while(temp.right != null && temp.right != curr){
	   				temp = temp.right;	
	   			}

	   			//arleady connected boss
	   			if(temp.right == curr){
	   				temp.right = null;

	   				//this is golden opportunity
	   				temp.right = curr.right;
	   				curr.right = curr.left;
	   				curr.left = null;

	   				curr = temp.right;
	   			}else{
	   				temp.right = curr;
	   				curr = curr.left;
	   			}
	   		}
   		}	
    }



}