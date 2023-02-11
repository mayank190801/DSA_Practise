//let's solve this one
import java.util.*;

public class genericTree{
    
    //node class
    public class Node{
        int val = 0;
        List<Node> children;

        public Node(int val){
            this.val = val;
        }
    }


    //diameter - basically the max distance for sure
    //pretty much works the same for sure!
    static int diam = 0;
    public int diameter(TreeNode root){
    	if(root == null) return 0;

    	int fm = 0;
    	int sm = 0;
    	int mh = 0;

    	for(Node child : root.children){
    		int ht = diameter(child);

    		mh = Math.max(mh, ht);
    		
    		//simple code
    		if(fm < ht){
    			sm = fm;
    			fm = ht;
    		}else if(sm < ht){
    			sm = ht;
    		}
    	}

    	diam = Math.max(diam, fm + sm + 1);
    	return mh + 1;
    }

    public List<Integer> rootToNode(Node root, int data){
    	if(root.val == data){
    		List<Integer> ans = new ArrayList<>();
    		ans.add(root.val);
    		return ans;
    	}

    	//otherwise keep search
    	for(Node child : root.children){
    		List<Integer> get = rootToNode(child, data);
    		if(get.size() > 0){
    			get.add(root.val);
    			return get;
    		}
    	}

    	return new ArrayList<>();
    }

}















