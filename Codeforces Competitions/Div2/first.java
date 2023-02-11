import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import java.io.OutputStreamWriter;

public class first {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = scan.nextInt();

        while (test-- > 0) {

            int n = scan.nextInt();

            System.out.println(n);
            
            int odd = 0;
            int even = 0;


            for(int i = 0 ; i < n*2 ; i++){
                int x = scan.nextInt();
                if(x%2 ==1){
                    odd++;
                }else{
                    even++;
                }
            }

            

            String answer = "Yes";
            if(odd != even){
                answer = "No";
            }
            
            output.write(answer + "\n");
        }

        output.flush();
        output.close();

    }

}