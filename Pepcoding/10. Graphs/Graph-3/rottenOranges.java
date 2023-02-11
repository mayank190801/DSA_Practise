import java.util.ArrayDeque;

public class rottenOranges {
    public static void main(String[] args) {

    }

    //now think about what to do is more important in my POV
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int cnt = 0;
        int timer = 0;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 2) que.add(i*c + c);
                if(grid[i][j] == 1) cnt++;
            }
        }

        while(!que.isEmpty()){
            int size = que.size();
            if(cnt == 0) return timer;

            while(size--> 0){
                int curr = que.poll();
                int nr = curr/c;
                int nc = curr%c;

                for(int[] cdir : dir){
                    int nx = cdir[0] + nr;
                    int ny = cdir[1] + nc;

                    if(nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        que.add(nx*c + ny);
                        cnt--;
                    }
                }
            }
            timer++;
        }

        return cnt == 0? timer : -1;
    }

}
