import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class shortestPath {
    public static void main(String[] args) {

    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        if(grid[0][0] == 1) return -1;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        grid[0][0] = -1;
        que.add(0);

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1},{1,-1}, {-1,-1}, {1,1}, {-1,1}};
        int timer = 1;
        while(!que.isEmpty()){
            int size = que.size();
            while(size--> 0){
                int curr = que.poll();
                int i = curr/c;
                int j = curr%c;

                for(int[] cdir : dir){
                    int nx = cdir[0] + i;
                    int ny = cdir[1] + j;

                    if(nx >= 0 && nx < r && ny >= 0 && ny < c && dir[nx][ny] == 0){
                        if(nx == r - 1 && ny == c - 1) return timer;
                        que.add(nx * c + ny);
                        dir[nx][ny] = -1;
                    }
                }
            }
            timer++;
        }

        return -1;
    }
}
