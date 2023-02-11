class Solution {

    public List<TreeNode> allPossibleFBT(int n) {

        List<TreeNode> ans = new ArrayList<>();

        if(n == 0) return ans;

        if(n == 1){
            TreeNode node = new TreeNode(0);
            ans.add(node);
            return ans;
        }

        //if for more than one somehow ie 2 or 3 right??
        for(int i = 1; i < n; i+=2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-1-i);

        
            for(TreeNode leftNode : left){
                for(TreeNode rightNode : right){

                    TreeNode node = new TreeNode(0);
                    node.left  = leftNode;
                    node.right = rightNode;

                    ans.add(node);
                }
            }
        }

        return ans;
    }


}