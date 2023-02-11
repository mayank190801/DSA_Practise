class Solution {

	//heavy recursion used baby
    public boolean isSymmetric(TreeNode root) {
    	if(root == null) return true;
    	return isSymmetric_(root.left, root.right);
    }

    public boolean isSymmetric_(TreeNode p, TreeNode q){
    	if(p == null && q == null) return true;
    	if((p != null && q == null) || (p == null && q != null) || p.val != q.val) return false;

    	return isSymmetric_(p.left, q.right) && isSymmetric_(p.right, q.left);
    }


    //simpy figure it out, symmetric from one side on the
    public boolean isSymmetric(TreeNode root) {

        if(root == null) return true;

        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();

        if(root.left != null) q1.add(root.left);
        if(root.right != null) q2.add(root.right);

        while(!q1.isEmpty() && !q2.isEmpty()){

            if(q1.size() != q2.size()) return false;
            int size = q1.size();

            while(size --> 0){
                TreeNode top1 = q1.poll();
                TreeNode top2 = q2.poll();

                if(top1.val != top2.val) return false;

                if(top1.left != null && top2.right != null){
                    q1.add(top1.left);
                    q2.add(top2.right);
                }else if(top1.left != null || top2.right != null){
                    return false;
                }

                if(top1.right != null && top2.left != null){
                    q1.add(top1.right);
                    q2.add(top2.left);
                }else if(top1.right != null || top2.left != null){
                    return false;
                }
            }

        }

        return q1.isEmpty() && q2.isEmpty();
    }
  

}






