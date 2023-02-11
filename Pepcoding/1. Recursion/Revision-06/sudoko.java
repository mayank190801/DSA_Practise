import java.util.Arrays;

public class sudoko {
    public static void main(String[] args) {
        char[][] board = 
        { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
        { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
        { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
        { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
        { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };


        solveSudoku(board);
        // for(int i = 0; i < 9; i++){
        //     for(int j=  0; j < 9 ; j++){
        //         System.out.print(i + " " + j + " - ");
        //     }
        //     System.out.println();
        // }
    
    }

    //let's 
    public static void solveSudoku(char[][] board) {
        //double 
        int n = board.length;

        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];
        boolean[][] blocks = new boolean[n][n];
        
        //updating all the values in one loop for sure
        for(int i= 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != '.'){
                    //update rows and cols part for sure in here
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    cols[j][num] = true;

                    int idx = (i/3)*3 + (j/3);
                    blocks[idx][num] = true;
                }
            }
        }

        // for(boolean[] arr : blocks){
        //     for(boolean ar : arr){
        //         if(ar){
        //             System.out.print(1 + " ");
        //         }else{
        //             System.out.print(0 + " ");
        //         }
        //     }
        //     System.out.println();
        // }
        System.out.println();
        sudokoSolver(0, board, new boolean[n][n], new boolean[n][n], new boolean[n][n], n);
    }

    //let's solve it asap brother, and be as much as optimise as we can go, no worries brother
    public static void sudokoSolver(int idx, char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] blocks, int n){

        if(idx == 81){
            for(char[] ar : board){
                for(char ch : ar){
                    System.out.print(ch + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        int i = idx/n;
        int j = idx%n;

        if(board[i][j] != '.'){  
            //simply move ahead
            sudokoSolver(idx + 1, board, rows, cols, blocks, n);
        }else{
            //assume all the values from 1 to 9
            for(int k = 1; k <= 9; k++){
                if(isPossible(idx, board, rows, cols, blocks, n, k)){
                    //set the value and update all side
                    rows[i][k-1] = true;
                    cols[j][k-1] = true;
                    blocks[(i/3)*3 + j/3][k-1] = true;
                    
                    //send forward for the work
                    board[i][j] = (char)('0' + k);
                    sudokoSolver(idx + 1, board, rows, cols, blocks, n);
                    board[i][j] = '.';

                    //remove all the values and edits
                    rows[i][k-1] = false;
                    cols[j][k-1] = false;
                    blocks[(i/3)*3 + j/3][k-1] = false;
                }
            }
        }
    }
    
    public static boolean isPossible(int idx, char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] blocks, int n, int val){
        int i = idx/n;
        int j = idx%n;
        int bidx = (i/3)*3 + j/3;
        if(rows[i][val-1] || cols[j][val-1] || blocks[bidx][val-1]) return false;
        return true;
    }


    
}
