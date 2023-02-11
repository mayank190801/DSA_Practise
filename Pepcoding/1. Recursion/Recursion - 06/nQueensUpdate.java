public class nQueensUpdate {

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

    public static boolean nQueen( int bno, int tnq , String ans, boolean[] row, boolean[] col, boolean[] d1, boolean[] d2){

        if(tnq == 0){
            System.out.println(ans);
            return true;
        }

        boolean res = false;
        for(int i = bno; i < row.length * col.length; i++){
            int r = i / col.length;
            int c = i % col.length;

            if(!row[r] && !col[c] && !d1[r+c] && !d2[r-c+row.length-1]){
                //brriliant check to do babies
                //this way we don't have to check again and again
                row[r] = true;
                col[c] = true;
                d1[r+c] = true;
                d2[r-c+row.length-1] = true; 
                res = res || nQueen( i+1, tnq-1, ans + "r" + r + " c" + c + "\n", row, col, d1, d2);
                row[r] = false;
                col[c] = false;
                d1[r+c] = false;
                d2[r-c+row.length-1] = false; 
            }  
        }

        return res;
    }

    public static void main(String[] args){
        long st = System.currentTimeMillis();
        nQueen(0, 4, "", new boolean[4], new boolean[4], new boolean[7], new boolean[7]);
        long et = System.currentTimeMillis();

        System.out.println(et-st);
    }

}
