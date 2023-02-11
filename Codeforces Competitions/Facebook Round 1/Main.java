import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("output.txt");

        // Scanner ip = new Scanner(System.in);

        try (Scanner sc = new Scanner(new File("yup.txt")); PrintWriter out = new PrintWriter(f);) {

            int test = sc.nextInt();
            sc.nextLine();

            int index = 1;
            while(test -- > 0){
    
                int n = sc.nextInt();
                int m = sc.nextInt();
    
                int A = sc.nextInt();
                int B = sc.nextInt();

                sc.nextLine();

                // sc.nextInt();
    
                //now i should move forward
                //int min required
                int min = n + m - 1;
    
                if(!(min <= A && min <= B)){
                    out.println("Case #" + (index++) + ": " + "Impossible");
                    continue;
                }
    
                out.println("Case #" + (index++) + ": " + "Possible");
                //otherwise min is possible 
                int[][] t = new int[n][m];
                for(int i=  0; i < n; i++){
                    Arrays.fill(t[i], 1);
                }
    
                //now filling those left and right bottom corners
                //that would be 
                int left = B - (min - 1);
                int right = A - (min - 1);
    
                t[n-1][0] = left;
                t[n-1][m-1] = right;
    
                //let's max out all other nuisance
                for(int i =1 ;i  < n; i++){
                    for(int j = 1; j < m-1; j++){
                        t[i][j] = 999;
                    }
                }
    
                for(int i = 0; i < n ; i++){
                    for(int j = 0; j < m ; j++){
                        out.print(t[i][j] + " ");
                    }
                    out.println();
                }
                
            }

        }
    }
}
