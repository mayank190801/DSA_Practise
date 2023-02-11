import java.util.*;

public class VerticalOrderLevel {
    public static void main(String[] args) {
        
    }

    //triple something bna lo and then sort krdo simple
    public class pair{
        int l = 0;
        int v = 0;
        public pair(int l, int v){
            this.l = l;
            this.v = v;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<pair>> map = new HashMap<>();
        int[] min = new int[1];
        helper(root,0,0, min ,map);

        //sorting on the basis of level for other ease stuff
        //pretty easy stuff
        for(int key: map.keySet()){
            List<pair> list = map.get(key);
            // Collections.sort(list, new Comparator<pair>() {
            //     public int compare(pair a, pair b){
            //         if(a.l != b.l){
            //             return a.l - b.l;
            //         }
            //         return a.v - b.v;
            //     }
            // });

            //using lamba functions to make it easier to implement
            //and it looks 10x better than above code for sure
            Collections.sort(list, (a,b) ->{
                if(a.l != b.l){
                    return a.l - b.l;
                }
                return a.v - b.v;
            });
        }
        int m = min[0];
        List<List<Integer>> ans = new ArrayList<>();
        while(map.containsKey(m)){
            List<pair> list = map.get(m);
            List<Integer> sans = new ArrayList<>();
            for(pair p : list){
                sans.add(p.v);
            }
            m++;
            ans.add(sans);
        }
        return ans;
    }

    //width wise hashmap
    public void helper(TreeNode root, int level, int width, int[] min , HashMap<Integer, List<pair>> map){
        if(root == null) return;

        if( min[0] > width ){
            min[0] = width;
        }

        if(!map.containsKey(width)){
            map.put(width, new ArrayList<>());
        }

        map.get(width).add(new pair(level, root.val));
        helper(root.left, level+1, width-1,min, map);
        helper(root.right, level+1, width+1,min, map);
    }

    //homework for this question
    //do it for sure on your own!!! very important data to know
    //using level order and iterative basically

}
