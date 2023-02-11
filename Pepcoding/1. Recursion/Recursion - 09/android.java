public class android{
    public static void main(String[] args) {
        
        int m = 1;
        int n = 2;

        int[][] matrix = new int[10][10];
        matrix[1][3] = matrix[3][1] = 2;
        matrix[1][7] = matrix[7][1] = 4;
        matrix[7][9] = matrix[9][7] = 8;
        matrix[3][9] = matrix[9][3] = 6;
        matrix[1][9] = matrix[9][1] = matrix[3][7] = matrix[7][3] = 5;
        matrix[2][8] = matrix[8][2] = matrix[4][6] = matrix[6][4] = 5;

        int count = 0;
        boolean[] used = new boolean[10];

        for(int i = m; i <= n ; i++){
            count += solve(1,matrix,used,i) * 4;
            count += solve(2,matrix,used,i) * 4;
            count += solve(5,matrix,used,i);
        }

        System.out.println(count);
    }

    public static int solve(int pos, int[][] matrix, boolean[] used, int moves){
        if(moves <= 1) return moves;

        int count = 0;
        used[pos] = true;
        for(int i = 1 ; i <= 9 ; i++){
            //what are the conditions 
            if(used[i] == true) continue;
            //some more checks should be there
            //that is if  no gap is in there, or basically if there is then the given is uesd
            if(matrix[pos][i] == 0 || (used[matrix[pos][i]])){
                count += solve(i, matrix, used, moves-1);
            }
        }
        used[pos] = false;
        return count;
    }


}