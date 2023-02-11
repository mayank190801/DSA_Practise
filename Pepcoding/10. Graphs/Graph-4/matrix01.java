import java.util.ArrayDeque;

public class matrix01 {
    public static void main(String[] args) {

    }

    public int[][] updateMatrix(int[][] mat) {

        int r = mat.length;
        int c = mat[0].length;

        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(mat[i][j] == 0) que.add(i*c + j);
            }
        }

        int timer = 1;
        while(!que.isEmpty()){
            int size = que.size();
            while(size--> 0){
                int curr = que.poll();
                int cr = curr/c;
                int cc = curr%c;

                int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
                for(int[] cdir : dir){
                    int nx = cdir[0] + cr;
                    int ny = cdir[1] + cc;

                    if(nx >= 0 && nx < r && ny >= 0 && ny < c && mat[nx][ny] == 1){
                        que.add(nx * c + ny);
                        mat[nx][ny] = -timer;
                    }
                }
            }
            timer++;
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                mat[i][j] = -mat[i][j];
            }
        }

        return mat;
    }
}
