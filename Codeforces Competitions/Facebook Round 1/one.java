import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.*;

public class one{

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
    
                int count = 0;
                boolean first = true;
                char last = '1';
    
                for(char ch : inp){
                    if(ch == 'X' || ch == 'O'){
                        if(first){
                            last = ch;
                            first = false;
                        }else{
                            if(last != ch){
                                count++;
                                last = ch;
                            }
                        }
                    }
                }
                out.println("Case #" + index + ": " + count);
                index++;
            }

        }
    }
}
