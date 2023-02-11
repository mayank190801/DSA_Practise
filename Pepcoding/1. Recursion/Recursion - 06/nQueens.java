public class nQueens {

    public static boolean isValidToPlace(boolean[][] board, int r, int c){
        int[][] dir = {{0,-1}, {-1,0}, {-1,-1}, {-1,1}};

        for(int k = 1; k < board.length; k++){
            for(int i= 0; i < dir.length; i++){
                int nr = r + dir[i][0]*k;
                int nc = c + dir[i][1]*k;

                if(nr >= 0 &&  nc >= 0 && nr < board.length && nc < board.length){
                    if(board[nr][nc]) return false;
                }
            }
        }

        return true;
    }

    public static boolean isValidToPlaceUpdate(boolean[][] board, int r, int c){
        int[][] dir = {{0,-1}, {-1,0}, {-1,-1}, {-1,1}};

        for(int i= 0; i < dir.length; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            while(nr >= 0 &&  nc >= 0 && nr < board.length && nc < board.length){
                if(board[nr][nc]) return false;
                nr += dir[i][0];
                nc += dir[i][1];
            }
        }
    
        return true;
    }

    public static boolean nQueen(boolean[][] board, int bno, int tnq , String ans){

        if(tnq == 0){
            System.out.println(ans);
            return true;
        }

        boolean res = false;
        for(int i = bno; i < board.length * board[0].length; i++){
            int r = i / board[0].length;
            int c = i % board[0].length;
            if(isValidToPlaceUpdate(board, r, c)){
                board[r][c] = true;
                res = res || nQueen(board, i+1, tnq-1, ans + "r" + r + " c" + c + "\n");
                board[r][c] = false;   
            }
        }

        return res;
    }

    public static void main(String[] args){

        boolean[][] board = new boolean[4][4];
        nQueen(board, 0, 4, "");
    }

}
