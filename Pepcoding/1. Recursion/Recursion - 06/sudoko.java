public class sudoko {
    public static void main(String[] args){

        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        sudoko_01(board, 0);

    }


    //let's think oabout how i can solve this problem, and no worries, is should solve it , and try to get good at it. No matter what
    //I should be able to solve it 
    



    ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////

    public static boolean isValid(char[][] board, int r, int c , int num){

        //not in the col
        for(int i = 0; i<9; i++){
            if(board[i][c]-'0' == num ) return false;
        }

        //not in the row
        for(int j = 0; j<9; j++){
            if(board[r][j]-'0' == num) return false;
        }

        //simple as that
        int nr = r/3 * 3;
        int nc = c/3 * 3;

        for(int i = nr; i < nr+3; i++){
            for(int j = nc ; j < nc+3; j++){
                if(board[i][j] -'0' == num) return false;
            }
        }
        
        return true;
    }

    public static boolean sudoko_01(char[][] board, int idx){

        if(idx == 81){
            for(char[] ch : board){
                for(char c : ch){
                    System.out.print(c);
                }
                System.out.println();
            }

            return true;
        }

        int r = idx / board.length;
        int c = idx % board.length;

        boolean res = false;
        if(board[r][c] != '.'){
            res = res || sudoko_01(board, idx+1);
            
        } else{
            for(int i= 1; i <= 9; i++){
                if(!isValid(board, r, c, i)) continue;
                board[r][c] = (char)('0' + i);
                res = res || sudoko_01(board, idx+1);
                board[r][c] = '.';
            }

        }
        return res;

    }
    
}
