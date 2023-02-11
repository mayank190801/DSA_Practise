public class validSudoko {

    public static boolean isValid(char[][] board, int r, int c, int num){
        
        //now for these certain r and c check it's valid
        for(int i = 0; i < 9; i++){
            if(board[r][0]-'0' == num) return false;
        }

         for(int i = 0; i < 9; i++){
            if(board[0][c]-'0' == num) return false;
        }
        
        int nr = r/3 * 3;
        int nc = c/3 * 3;
        
        for(int i = nr ; i < nr+3; i++){
            for(int j = nc ; j < nc + 3; j++){
                if(board[i][j] - '0' == num) return false;
            }
        }
        
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9 ; j++){
                if(board[i][j] == '.') continue;
                char temp = board[i][j];
                board[i][j] = '.';
                if(!isValid(board, i,j, temp-'0')) return false;
                board[i][j] = temp;
            }
        }
        
        return true;
    }
    public static void main(String[] args){

        //it had few issues 
        //only in the check condition only to be honest



    }
    
}
