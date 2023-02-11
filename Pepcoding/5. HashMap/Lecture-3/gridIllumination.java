import java.util.*;

class Solution {

    //This piece of code works, now let's do something on it
    //let's solve this bad boi
    HashMap<Long, Integer> bulb = new HashMap<>();
    HashMap<Integer, Integer> row = new HashMap<>();
    HashMap<Integer, Integer> col = new HashMap<>();
    HashMap<Integer, Integer> d1 = new HashMap<>();
    HashMap<Integer, Integer> d2 = new HashMap<>();

    //some syntax error needs to be solved for sure
    //boi boi boi boi boi boi bboi boi boi boi boi boi
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        bulb = new HashMap<>();
        row = new HashMap<>();
        col = new HashMap<>();
        d1 = new HashMap<>();
        d2 = new HashMap<>();
        //all for the sake initial mapping bois
        for(int[] arr : lamps){
            int r = arr[0];
            int c = arr[1];

            //let's do 1D mapping for this 2d array bois
            //so cool for sure
            long idx = r*n + c;
            bulb.put(idx, bulb.getOrDefault(idx, 0)+ 1);
            row.put(r, row.getOrDefault(r, 0) + 1);
            col.put(c, col.getOrDefault(c, 0) + 1);
            d1.put(r+c, d1.getOrDefault(r+c, 0) + 1);
            d2.put(r-c, d2.getOrDefault(r-c, 0) + 1);
        }

        int[] ans = new int[queries.length];
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int i = 0 ; i < queries.length; i++){
            int[] arr = queries[i];
            int r = arr[0];
            int c = arr[1];
            long idx = r * n + c;

            //any one of them maybe lightning it
            if(row.getOrDefault(r,0) != 0 || col.getOrDefault(c,0) != 0 || d1.getOrDefault(r+c,0) != 0 || d2.getOrDefault(r-c,0) != 0){
                ans[i] = 1;
            }
            //updation of grid and shit to be done in here
            //own bulb
            if(bulb.getOrDefault(idx,0) != 0){
                updateGrid(r,c,idx, n);
            }
            //8 adjacent bulbs
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                long nidx = nr * n + nc;
                updateGrid(nr, nc, nidx, n);
            }
        }

        return ans;
    }

    //simple updation was necessary for sure boi
    //always remember this for sure boi
    public void updateGrid(int r , int c, long idx,int n){
        if(r >= 0 && c >= 0 && r < n && c < n && bulb.getOrDefault(idx,0) != 0){
            int ct = bulb.get(idx);
            bulb.put(idx, 0);
            if(row.containsKey(r))
                row.put(r, row.get(r) - ct);
            if(col.containsKey(c))
                col.put(c, col.get(c) - ct);
            if(d1.containsKey(r+c))
            d1.put(r+c, d1.get(r+c) - ct);
            if(d2.containsKey(r-c))
            d2.put(r-c, d2.get(r-c) - ct);

        }
    }

}