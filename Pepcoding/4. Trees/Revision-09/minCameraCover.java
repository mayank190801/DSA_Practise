class Solution {

	//story of take or not take types
	static int camera = 0;

    public int minCameraCover(TreeNode root) {
    	camera = 0;
    	int get = helper_(root);
    	if(get == -1) camera++;
    	return camera;
    
    }

    //if need a camera -1
    //you have a camera 0 
    //if you are covered 1 

    public int helper_(TreeNode root){
    	if(root == null){
    		return 1;
    	}

    	if(root.left == null && root.right == null) {
    		return -1;
    	}

    	//simple
    	int left = helper_(root.left);
    	int right = helper_(root.right);

    	if(left == -1 || right == -1){
    		camera++;
    		return 0;
    	}


    	if(left == 0 || right == 0){
    		return 1;
    	}

    	return -1;
    }

    



}