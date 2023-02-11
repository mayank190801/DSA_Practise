public class nQueensTesting {

        public static boolean nQueens03(int floor, int tnq, String ans, boolean[] row, boolean[] col, boolean[] d1,
        boolean[] d2) {
    // floor-> row
    // room-> column
    if (tnq == 0) {
        System.out.println(ans);
        return true;
    }
    boolean res = false;
    for (int room = 0; room < row.length; room++) {
        int r = floor;
        int c = room;
        if (!row[r] && !col[c] && !d1[r + c] && !d2[r - c + row.length - 1]) {
            row[r] = true;
            col[c] = true;
            d1[r + c] = true;
            d2[r - c + row.length - 1] = true;
            nQueens03(floor + 1, tnq - 1, ans + "r" + r + "c" + c + "\n", row, col, d1, d2);
            row[r] = false;
            col[c] = false;
            d1[r + c] = false;
            d2[r - c + row.length - 1] = false;
        }
    }
    return res;
    }
        
    public static void main(String[]args){
          boolean[][] board = new boolean[4][4];
        // nQueens(board, 0, 4, "");
        // nQueens02(0, 4, "", new boolean[4], new boolean[4], new boolean[7], new
        // boolean[7]);
        nQueens03(0, 4, "", new boolean[4], new boolean[4], new boolean[7], new boolean[7]);
        long et = System.currentTimeMillis();

    }
    
}
