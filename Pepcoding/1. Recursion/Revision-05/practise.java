import java.io.*;
import java.util.*;

public class practise {
	public static void main(String[] args){
		solver(new int[2][2], 0, 0, 2, 2, 2);
	}

	//let's figure this out for once no matter what
	//123 in 5 boxes using subsequence 

	//queen2D as 2D 
	public static void solver( int[][] box, int x, int y, int qleft, int n, int m){

		//for loops mein when target is achieved!
		if(qleft == 0){
			for(int[] que: box){
				for(int q : que){
					System.out.print(q + " ");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for(int i = x; i < n; i++){
			for(int j = 0; j < m; j++){
				if(i == x && j < y) continue;
				//otherwise not bois
				
					box[i][j] = 1;
					solver(box, j == m - 1 ? i + 1 : i, j == m - 1 ? 0 : j + 1, qleft-1, n, m);
					box[i][j] = 0;
				
			}
		}

	}

}

