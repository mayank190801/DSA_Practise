import java.util.HashMap;
import java.util.Map;

public class inLevelorder {
    public class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //inorder and level order
    //hence solved buddy, so proud of you for real man!!!
    //literally solved that question on your own, trust your own coding abilities idiot
    Node buildTree(int inord[], int level[])
    {
        Map<Integer, Integer> pos = new HashMap<>();
        for(int i= 0; i < inord.length; i++){
            pos.put(inord[i], i);
        }
        return helper(inord, level, 0, inord.length-1, pos);
    }

    Node helper(int[] inord, int level[], int is, int ie, Map<Integer, Integer> pos){
        if(is > ie) return null;
        if(level.length == 0) return null;

        Node temp = new Node(level[0]);

        int ii = pos.get(level[0]);
        //position of ith index
        int lcount = ii - is;
        int[] lolt = new int[lcount];
        int[] lort = new int[ie- ii];
        int lr = 0;
        int rr = 0;

        //then make this shit real
        for(int i = 1; i < level.length; i++){
            int idx = pos.get(level[i]);
            if(idx < ii){
                lolt[lr] = level[i];
                lr++;
            }else{
                lort[rr] = level[i];
                rr++;
            }
        }

        temp.left = helper(inord, lolt, is, ii-1, pos);
        temp.right = helper(inord, lort, ii+1, ie, pos);
        return temp;
    }
    

}
