public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root == null){
    		return "n";
    	}

    	String left = serialize(root.left);
    	String right = serialize(root.right);

    	return root.val + "#" + left + "#" + right;
    }


    // Decodes your encoded data to tree.
    int ptr = 0;

    public TreeNode deserialize(String data) {
    	String[] inp = data.split("#");
    	ptr = 0;
    	return deserialize_(inp);
    }

    public TreeNode deserialize_(String[] inp){
    	if(inp[ptr].equals("n")){
    		ptr++;
    		return null;
    	}

    	TreeNode curr = Integer.parseInt(inp[ptr]);
    	ptr++;
    	curr.left = deserialize_(inp);
    	curr.right = deserialize_(inp);

    	return curr;
    }

}