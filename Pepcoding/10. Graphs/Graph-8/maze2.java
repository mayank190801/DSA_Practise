import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class maze2 {
    public static void main(String[] args) {

    }

    //now I have to find the shortest distance to that point
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;

        int[][] direction = {{0,-1},{0,1},{1,0},{-1,0}};
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> a[2] - b[2]); //x,y,steps
        que.add(new int[]{start[0], start[1], 0});

        int[][] dist = new int[n][m];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start[0]][start[1]] = 0;
         //pre mark lets say

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int x = curr[0];
            int y = curr[1];
            int stepsTillNow = curr[2];

            if(x == destination[0] && y == destination[1]) break;
            if(maze[start[0]][start[1]] == 2) continue;
            maze[start[0]][start[1]] = 2; //otherwise mark it as first time reached

            //now finding and adding other points
            for(int[] dir : direction){
                //let say roll on right
                int nx = x;
                int ny = y;
                int steps = 0;
                while(nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] != 1){
                    nx += dir[0];
                    ny += dir[1];
                    steps++;
                }
                nx -= dir[0];
                ny -= dir[1];

                if(maze[nx][ny] == 0){
                    if(steps + stepsTillNow < dist[nx][ny]){
                        dist[nx][ny] = steps + stepsTillNow;
                        que.add(new int[]{nx, ny, dist[nx][ny]});
                    }
                }
            }
        }

        int dx = destination[0];
        int dy = destination[1];
        return dist[dx][dy] == Integer.MAX_VALUE ? -1 : dist[dx][dy];

    }
}
