import java.util.ArrayList;
import java.util.List;

public class leetcode11 {

    public static void main(String[] args) {

    }

    //now go beyond and start learning more vim notions, alFs
    //how do you figure out the time complexity for this solution??
    //that is difficult part for sure - finding complexity of a recursive solution -
    public static class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public static int minimumMoves(int[][] grid) {
        //I need a pair?? or what?? - I though of doing it in pairs maybe
        List<Pair> empty = new ArrayList<>();
        List<Pair> extra = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++ ){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                   empty.add(new Pair(i, j));
                }
                if(grid[i][j] > 1){
                   extra.add(new Pair(i, j));
                }
            }
        }

        //so this way you have something
        if(empty.size() == 0) return 0;

        //otherwise you can go on with your solution of making big in this industry - coding daily is important
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        solver(grid, n, m, empty, extra, 0, ans, 0);
        return ans[0];
    }

    public static void solver(int[][] grid, int n, int m, List<Pair> empty, List<Pair> extra, int emIdx, int[] ans, int moves){
       //this way we have pretty much everything
       if(emIdx == empty.size()){
           ans[0] = Math.min(ans[0], moves);
           return;
       }

       //so now we would have some position from here
       Pair curr = empty.get(emIdx);
       for(int i = 0; i < extra.size(); i++){
           Pair ecurr = extra.get(i);
           int u = ecurr.a;
           int v = ecurr.b;

           //now check if we can place at that position
           if(grid[u][v] > 1){
               grid[u][v]--;
               int cost = Math.abs(curr.a - u) + Math.abs(curr.b - v);
               solver(grid, n, m, empty, extra, emIdx + 1, ans, moves + cost);
               grid[u][v]++;
           }
       }
    }

}
