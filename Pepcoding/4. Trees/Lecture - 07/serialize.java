public class serialize {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //annoying questions for sure
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "n";
        }
        String ans = "";
        String left = serialize(root.left);
        String right = serialize(root.right);
        ans = root.val + "#" + left + "#" + right;
        return ans;
    }

    // Decodes your encoded data to tree.
    static int ptr = 0;
    public TreeNode deserialize(String data) {
        ptr = 0;
        String[] splitted = data.split("#");
        return deserialize_(splitted);
    }

    //pretty cool for sure
    //Hard to remember this method for sure man
    public TreeNode deserialize_(String[] arr){
        if(arr[ptr].equals("n")){
            ptr++;
            return null;
        }
        //convert string to int
        int val = Integer.parseInt(arr[ptr]);
        TreeNode root = new TreeNode(val);
        ptr++;
        root.left = deserialize_(arr);
        root.right = deserialize_(arr);
        return root;
    }
}
