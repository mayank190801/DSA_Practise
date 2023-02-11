class Solution{

	public Tree cloneTree(Tree tree){
    	//three functions
    	clone(tree);
    	setRandom(tree);
    	return diverge(tree);
    }

    //data , left , right , random
    public void clone(Tree tree){
    	if(tree == null) return;

    	Tree node = new Tree(tree.data);
    	node.left = tree.left;
    	tree.left = node;

    	//now send it do it's workd
    	clone(tree.right);
    	clone(tree.left.left);
    }


    public void setRandom(Tree tree){
    	if(tree == null) return;

    	Tree point = tree.random;
    	if(point != null){
    		tree.left.random = point.left;
    	}

    	setRandom(tree.right);
    	setRandom(tree.left.left);
    }

    //it's simply return the answer tree, and fix the current tree
    public Tree diverge(Tree tree){
    	if(tree == null) return null;

 		Tree node = tree.left;  //this is what we have to return
 		tree.left = node.left;
 		   	
 		node.left = diverge(tree.left);
 		node.right = diverge(tree.right);

 		return node;
    }

}












