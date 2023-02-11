
import java.util.*;
import java.io.*;

public class Queen2Das2D{
	
    // public static void main(String[] args) throws Exception {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int n = Integer.parseInt(br.readLine());
        
    //     queensCombinations(0, n, 0, 0, "");
    // }

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations2(0, n, chess, 0, 0);
    }

	// public static void main(String[] args) throws Exception {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int n = Integer.parseInt(br.readLine());
    //     int[][] chess = new int[n][n];
        
    //     queensPermutations(0, n, chess);
    // }
   
    // public static void main(String[] args) throws Exception {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int n = Integer.parseInt(br.readLine());
    //     boolean[][] chess = new boolean[n][n];

    //     queensCombinations1D(0, n, chess, 0);
    // }

	//let's fucking practise go!! (Queen 2D should be understood and implementable bois)
	//to see how good we are at this is important for sure!

	//Queen Combination - 1 ( subsequence approach )
	//queen places so far, total queens, row, col ,answer so far - pretty dope for sure - n queens on n * n board
	public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
		if(row == tq){
			if(qpsf == tq){
				System.out.println(asf);
			}
			return;
		}

		if(col == tq - 1){
			//take or don't take
			queensCombinations(qpsf + 1, tq, row + 1, 0, asf + "q\n");
			queensCombinations(qpsf, tq, row + 1, 0, asf + "-\n");
		}else{
			queensCombinations(qpsf + 1, tq, row, col + 1, asf + "q");
			queensCombinations(qpsf, tq, row, col + 1, asf + "-");
		}

    }


	//Queen Combinations - 2 ( for loop approach probably )
	//int i and j for current position, that's what i think boi
	//pehle ye toh krlu mein boss - super annoying tactic for fuck sake
	//2D as 1D v
	public static void queensCombinations2(int qpsf, int tq, boolean[][] chess, int x, int y){
        // write your code here
		if(qpsf == tq){
			// System.out.println(Arrays.deepToString(chess));
			for(int i = 0; i < chess.length; i++){
				for(int j = 0; j < chess[0].length; j++){
					if(chess[i][j]){
						System.out.print("q\t"); 
					}else{
						System.out.print("-\t");
					}
				}
				System.out.println();
			}
			System.out.println();

			return;
		}

		// System.out.println(x + " " + y);
		//otherwise simple technique to be used 
		for(int i = x; i < chess.length; i++ ){
			for(int j = y; j < chess[0].length; j++){
				chess[i][j] = true;
				//future senders boss!
				//0,1 
				//1,0
				int nx = j == (chess.length - 1) ? (i + 1) : i;
				int ny = j == (chess.length - 1) ? 0 : j + 1;
				// System.out.println(x + " " + y);
				queensCombinations2(qpsf + 1, tq, chess, nx, ny);
				chess[i][j] = false;
			}
		}
    }

	///Queen Permutations - 2D as 2D (using subsequene now for real)
	public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if(row == tq){
			if(qpsf == tq){
				System.out.println(asf);
				System.out.println();
			}
			return;
		}

		//qpsf
		//for loop first one
		for(int i = 0; i < queens.length; i++){
			if(queens[i]) continue;
			queens[i] = true;
			//move forward simply
			if(col == tq - 1){
				queensPermutations(qpsf + 1, tq, row + 1, 0, asf + "q" + (i+1) + "\n", queens);
			}else{
				queensPermutations(qpsf + 1, tq, row, col + 1, asf + "q" + (i+1) + "\t", queens);
			}
			queens[i] = false;
		}

		if(col == tq - 1){
			queensPermutations(qpsf, tq, row + 1, 0, asf + "-" + "\n", queens);
		}else{
			queensPermutations(qpsf, tq, row, col + 1, asf + "-" + "\t", queens);
		}
		

    }
    

	//Queen Permutations - 2D as 2D (using for loop method)
	//queens placed so far, total queens
	public static void queensPermutations2(int qpsf, int tq, int[][] chess){
		//single permutation (using placement array)
		if(qpsf == tq){
			//simply output the answer using chess
			for(int i= 0; i < chess.length; i++){
				for(int j= 0; j < chess.length; j++){
					if(chess[i][j] == 0){
						System.out.print("-" + "\t");
					}else{
						System.out.print("q" + chess[i][j] + "\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for(int i= 0; i < chess.length; i++){
			for(int j = 0; j < chess.length; j++){
				if(chess[i][j] == 0){
					chess[i][j] = qpsf + 1;
					queensPermutations2(qpsf + 1, tq, chess);
					chess[i][j] = 0;
				}
			}
		}
    }


	//ONE FUCKING EXTRA QUESTION FOR YOU BOIS - let's solve this bad
	//SIMILARLY YOU CAN CONVERT ALL OF THEM INTO 1D and SOLVE THEM!!! (pretty dope shit)
	//TOTALLY LOVED IT!!! (loved loved loved)
	public static void queensCombinations1D(int qpsf, int tq, boolean[][] chess, int lcno) {

		if(qpsf == tq){
			// System.out.println(Arrays.deepToString(chess));
			for(int i = 0; i < chess.length; i++){
				for(int j = 0; j < chess.length; j++){
					if(chess[i][j]){
						System.out.print("q" + "\t");
					}else{
						System.out.print("-" + "\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		//convert lcno to rows and cols, and place it on here
		int n = chess.length;
		for(int i = lcno; i < n * n; i++){
			int row = i/n;
			int col = i%n;

			chess[row][col] = true;
			queensCombinations1D(qpsf + 1, tq, chess, i + 1);
			chess[row][col] = false;
		}

    }

}