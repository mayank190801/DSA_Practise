import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.*;

public class sfsds{

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("output.txt");

        // Scanner ip = new Scanner(System.in);

        try (Scanner sc = new Scanner(new File("yup.txt")); PrintWriter out = new PrintWriter(f);) {

            int test = sc.nextInt();
            sc.nextLine();
            int index = 1;
    
            while(test -- > 0){
    
                int n = sc.nextInt();
                sc.nextLine();
                char[] inp = sc.nextLine().toCharArray();
    
                //so the game is mainly played here, let's code and plan 
                //out thing now 
                long mod = 1_000_000_007;

                long mainSum = 0;
                long lastVal = 0;

                char last = '1';

                long xloc = -1;
                long oloc = -1;

                long total = 0;

                for(int i = 0; i < n ; i++){

                    if(inp[i] == 'X'){
                        if(last == 'X'){
                            total += lastVal;
                            total %= mod;
            
                        }else{
                            //then the main game is played
                            long curr = (long)Math.abs((int)oloc - (int)xloc);

                            total += lastVal + mainSum; 
                            total += curr;
                            total %= mod;

                            //always //basically the logic of updation is important
                            lastVal = lastVal + mainSum + curr;
                            mainSum += curr;

                            lastVal %= mod;
                            mainSum %= mod;
                        }

                        xloc = i;
                        last = 'X';
                    }

                    if(inp[i] == 'O'){
                        if(last == 'O'){
                            total += lastVal;
                            total %= mod;      
                        
                        }else{
                            long curr = (long)Math.abs((int)xloc - (int)oloc);
                            
                            total += lastVal + mainSum; 
                            total += curr;
                            total %= mod;

                            //always //basically the logic of updation is important
                            lastVal = lastVal + mainSum + curr;
                            mainSum += curr;

                            lastVal %= mod;
                            mainSum %= mod;
                        }

                        oloc = i;
                        last = 'O';
                    }

                    //if anytime 'F' is there just do this
                    if(inp[i] == 'F'){
                        total += lastVal;
                        total %= mod;
                    }
                }

                out.println("Case #" + index + ": " + total);
                index++;
            }

        }
    }
}
