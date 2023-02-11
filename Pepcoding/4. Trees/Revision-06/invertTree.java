class Solution {
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) return null;
    	root.left = invertTree(root.right);
    	root.right = invertTree(root.left);

    	return root;
    }


    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            while(size --> 0){
                TreeNode top = que.poll();

                //now just reverse its child and add them
                TreeNode left = top.left;
                TreeNode right = top.right;

                top.left = right;
                top.right = left;

                if(left != null) que.add(left);
                if(right != null) que.add(right);
            }
        }


        return root;
    }
}