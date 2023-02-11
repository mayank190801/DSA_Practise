public class surroundRegions {
    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(board[i][j] == 'O') markUseless(board, i, j, n, m);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '.'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void markUseless(char[][] board, int i, int j, int n, int m){
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        board[i][j] = '.';

        for(int[] cdir : dir){
            int nx = cdir[0] + i;
            int ny = cdir[1] + j;

            if(nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] != 'O') continue;
            markUseless(board, nx, ny, n, m);
        }
    }



}
