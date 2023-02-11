public class inPostorder {

    //the logic in this one was a bit different
    //i thought of doing it completely opposite, but sir did it a very different manner, 
    //not changing a lot of stuff for this one
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
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, postorder.length-1, 0);  
    }

    //in this one it will start from the end to be honest, think how you will be able to implement it
    //a bit tricky for sure, think about it for a second 
    //hehe solved with clear mind for sure, it ain't that hard, it just takes more time to be solved for sure
    //graph and shit is left tho, be aware of that , dynamic programmingg, it will always be my weak topic, lol
    //not gonna be true, i know about myself

    public TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){

        //think about this one, and how to traverse the same shit again for sure
        if(pe > ps) return null;

        //simply to find the position 
        int i= 0;
        for( i = is ; i <= ie ; i++){
            if(inorder[i] == postorder[ps]){
                break;
            }
        }

        //now find the element on the right basically
        TreeNode temp = new TreeNode(postorder[ps]);
        int rcount = ie - i;
        //i like to film for sure, let's focus on that for a second
        temp.left = helper(inorder, is, i-1, postorder, ps-rcount-1, pe);
        temp.right = helper(inorder, i+1, ie, postorder, ps-1, ps-rcount);
        return temp;

    }

    
}

//kamal sir version, very less changed from the last one
/*
public TreeNode buildTree(int[] in, int[] post) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
        map.put(in[i], i);
    }
    return postInTree(post, 0, post.length - 1, in, 0, in.length - 1, map);
}

public TreeNode postInTree(int[] post, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map) {
    if (ps > pe) {
        return null;
    }
    TreeNode node = new TreeNode(post[pe]);
    int i = map.get(post[pe]);

    int lcount = i - is;
    node.left = postInTree(post, ps, ps + lcount - 1, in, is, i - 1, map);
    node.right = postInTree(post, ps + lcount, pe - 1, in, i + 1, ie, map);
    return node;
}
*/
