public class tempTest {

    public static void main(String[] args) {

        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };


        solveSudoku(board);
        //ek baar krke chodh diay simple
    
    }

    
    public static void sudoko_02(char[][] board, int idx, boolean[][] rows, boolean[][] cols, boolean[][] blocks){

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

       int r = idx / board.length;
       int c = idx % board.length;

       boolean res = false;
       if(board[r][c] != '.'){
            sudoko_02(board, idx+1, rows, cols, blocks);
           
       } else{
           for(int i= 1; i <= 9; i++){

               //check for the validity here for now
               //now for the blocks it's lil typical
               int blockIndex = (r/3*3) + (c/3*3)/3;

               if(rows[r][i-1] || cols[c][i-1] || blocks[blockIndex][i-1]) continue;
               rows[r][i-1] = true;
               cols[c][i-1] = true;
               blocks[blockIndex][i-1] = true;
               
               board[r][c] = (char)('0' + i);
               sudoko_02(board, idx+1, rows, cols, blocks);
               board[r][c] = '.';

               rows[r][i-1] = false;
               cols[c][i-1] = false;
               blocks[blockIndex][i-1] = false;   
           }

       }
       return;
    }
   
   
   public static void solveSudoku(char[][] board) {
       
       boolean[][] rows = new boolean[9][9];
       boolean[][] cols = new boolean[9][9];
       boolean[][] blocks = new boolean[9][9];

       //now i gotta fill them first, and then keep checking and moving one with life, no worries
       //let's gotta do this
       for(int i = 0; i < 9; i++){
           for(int j = 0; j < 9; j++){
               if(board[i][j] == '.') continue;
               rows[i][board[i][j] -'0'-1] = true; 
           }
       }

       for(int i = 0; i < 9; i++){
           for(int j = 0; j < 9; j++){
               if(board[j][i] == '.') continue;
               cols[i][board[j][i]-'0'-1] = true;
           }
       }

       //now update the boxes however you like them
       for(int i = 0; i < 3; i++){
           for(int j = 0; j < 3; j++){
               //at this point we have 
               //0,0
               //multiply both by 
               int ni = i*3;
               int nj = j*3;

               //with this above shit we can also get the block location vaise toh
               int index =  ni + j;
               // System.out.println(index); 

               for(int k = ni; k < ni+3; k++){
                   for(int l = nj; l < nj+3; l++){
                       if(board[k][l] == '.') continue;
                       blocks[index][board[k][l]-'0'-1] = true;
                   }
               }
           }
       }

       sudoko_02(board, 0, rows, cols, blocks);
       
   }
}