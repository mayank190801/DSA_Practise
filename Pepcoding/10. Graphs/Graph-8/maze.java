import java.util.ArrayDeque;

public class maze {
    public static void main(String[] args) {


    }

    //using bfs and stuff
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;

        int[][] direction = {{0,-1},{0,1},{1,0},{-1,0}};
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{start[0], start[1]});
        //2 for visited basically no?
        maze[start[0]][start[1]] = 2; //pre mark lets say

        //damn fuck yeah

        //we have our que ready
        while(!que.isEmpty()){
            int[] curr = que.poll();
            int x = curr[0];
            int y = curr[1];

            if(x == destination[0] && y == destination[1]) return true;

            //now finding and adding other points
            for(int[] dir : direction){
                //let say roll on right
                int nx = x;
                int ny = y;
                while(nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] != 1){
                    nx += dir[0];
                    ny += dir[1];
                }
                nx -= dir[0];
                ny -= dir[1];

                if(maze[nx][ny] == 0){
                    que.add(new int[]{nx, ny});
                    maze[nx][ny] = 2;
                }
            }
        }

        return false;
    }

}
