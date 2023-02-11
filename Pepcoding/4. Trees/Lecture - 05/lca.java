import java.util.*;

import org.w3c.dom.Node;
public class lca {
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

    //let's solve this question on your own
    //FIRST METHOD
    //USING EXTRA SPACE 
    //TIME O(N) - very important to notice for sure bruh
    //SPACE O(N) - pretty clear
    //this code does work tho, pretty happy about it heheheh
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> first = rootToNodePath(root, p.val); // O(n)
        List<TreeNode> second = rootToNodePath(root, q.val); //O(n)

        Collections.reverse(first);   
        Collections.reverse(second);

        //if it is empty then what?
        //if any one is empty return some shit, i don't know, i don't think so this code
        //would work, his is a bit different for sure
        TreeNode ans = first.get(0);
        int i = 0;
        while(i < Math.min(first.size(), second.size())){ // O(n)
            if(first.get(i).val == second.get(i).val){
                ans = first.get(i);
                i++;
            }else{
                break;
            }
        }
        
        return ans;
    }

    //their method to for root to node path, pretty annoying, but let's do it
    //it is made from find function, and find function is made from res || and shit
    //so this is working beautifully for sure, let's use it in our code
    public List<TreeNode> rootToNodePath(TreeNode root, int data){
        //now fix base cases
        List<TreeNode> answer = new ArrayList<>();
        if(root == null) return answer;

        if(root.val == data){
            answer.add(root);
            return answer;
        }

        List<TreeNode> left = rootToNodePath(root.left, data);
        List<TreeNode> right = rootToNodePath(root.right, data);

        if(left.size() > 0){
            left.add(root);
            return left;
        }

        if(right.size() > 0){
            right.add(root);
            return right;
        }

        return answer;
    }
    

    //SECOND METHOD 
    //without extra space probably
    //figure this out on your own for god sake brother 
    //lca without space with bug
    //does work for people having value for sure 
    boolean f1 = false; //p1 is existence
    boolean f2 = false; //p2 is exsitence
    //simply check them both

    //simple shit bro
    //this code is sick bro, sick as fuck man!!!!!
    //only sir could have taught this for sure
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = lowestCommonAncestor_(root, p, q);
        if(f1 == true && f2 == true){
            return ans;
        }
        return null;
    }

    public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        TreeNode temp = null;
        if(root.val == p.val){
            f1 = true;
            temp = root;
        }   
        if(root.val == q.val){
            f2 = true;
            temp = root;
        } 
        
        TreeNode left = lowestCommonAncestor_(root.left, p, q);
        TreeNode right = lowestCommonAncestor_(root.right, p, q);

        if(temp != null) return temp;
        if(left != null && right != null) return root;
        
        //most op code out there for sure
        return left == null ? right : left;
    }

    //method one to fix bug
    //find both and check if both exist
    
    //method two
    //f1 and f2 static flags to tell if both are found or not
    //try solving this above shit using TreeNode[] and all, pretty dope if you ask me
    //PRACITSE IT ON YOUR OWN


    //LCA 3 with parent is same linkedlist with intersection shit and all
    //simple method, but do remember this bitch for sure
    public Node lowestCommonAncestor(Node p1, Node p2){
        Node c1 = p1;
        Node c2 = p2;

        while(c1 != c2){
            c1 = c1 == null ? p2 : c1.parent;
            c2 = c2 == null ? p1 : c2.parent;
        }

        return c1;
    }



    

    
}
