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

    //height
    public int height(Node root){
        //base case baby
        int ans = 0;

        for(Node child: root.children){
            ans = Math.max(ans, height(child));
        }

        return ans +1 ;
    }

    //Diameter
    int dia = 0;
    //brilliant code
    //update the above static variable bois
    public int diameter(Node root){
        //check these edge and node basis shit
        int max = -1;
        int smax = -1;
        for(Node child : root.children){
            int cval = diameter(child);
            if(cval > max){
                smax = max;
                max = cval;
            }else if(cval > smax){
                smax = cval;
            }
        }

        dia = Math.max(dia, smax + max + 2);
        return Math.max(max, smax) + 1;        
    }

    //root to node path
    //derived from find function, remember that boi
    //similar to last function baby
    public List<Integer> rootToNode(Node root, int data){
        if(root.val == data){
            List<Integer> base = new ArrayList<>();
            base.add(root.val);
            return base;
        }

        for(Node child : root.children){
            List<Integer> list =  rootToNode(child, data);
            if(list.size() > 0){
                list.add(root.val);
                return list;
            }
        }
        return new ArrayList<>();
    }

    //LCA
    //dusra one was annoying, if exist or not and shit
    //bug and without bug code baby 
    public Node LCA(Node root , int p, int q){

        if(root.val == p){
            return root;
        }

        if(root.val == q){
            return root;
        }

        int ct = 0;
        Node single = null;

        for(Node child : root.children){
            Node node = LCA(child,p,q);
            if(node != null) ct++;

            //again updating and updating bruh
            //i could clearly find bug duh, hehe
            if(ct == 1 && node != null){
                single = node;
            }

        }

        if(ct == 2){
            return root;
        }

        //simple as that boi
        //bug not handled yet tho
        return single;
    }

    
}
