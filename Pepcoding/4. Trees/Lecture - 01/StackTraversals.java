import java.util.*;

public class StackTraversals {

    //O(n)
    //O(logn)

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

    }

    public class travel{
        TreeNode node;
        boolean sd = false;
        boolean ld = false;
        boolean rd = false;

        public travel(TreeNode node){
            this.node = node;
        }

    }

    //preorder stack
    public List<Integer> preOrderStack(TreeNode node){

        //base case baby
        if(node == null){
            return new ArrayList<>();
        }

        Stack<travel> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(new travel(node));

        //brilliant way of solving this for sure
        while(!st.isEmpty()){

            var top = st.peek();
            if(!top.sd){
                ans.add(top.node.val);
                top.sd = true;
            }else if(!top.ld){
                if(top.node.left != null)
                    st.add(new travel(top.node.left));
                top.ld = true;
            }else if(!top.rd){
                if(top.node.right != null)
                    st.add(new travel(top.node.right));
                top.rd = true;
            }else{
                st.pop();
            }

        }

        return ans;
    }

    //inorder stack
    public List<Integer> inOrder(TreeNode node){

        //base case baby
        if(node == null){
            return new ArrayList<>();
        }

        Stack<travel> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(new travel(node));

        //brilliant way of solving this for sure
        while(!st.isEmpty()){

            var top = st.peek();
            if(!top.ld){
                if(top.node.left != null)
                    st.add(new travel(top.node.left));
                top.ld = true;
            }else if(!top.sd){
                ans.add(top.node.val);
                top.sd = true;
            }else if(!top.rd){
                if(top.node.right != null)
                    st.add(new travel(top.node.right));
                top.rd = true;
            }else{
                st.pop();
            }

        }

        return ans;
    }

    
}
