import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.OutputStreamWriter;

public class first {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = scan.nextInt();
        while (test-- > 0) {

            long a = scan.nextLong();
            long b = scan.nextLong();

            long x = Math.abs(a-b);

            if(x == 0){
                output.write("0 0 \n");
                continue;
            }

            long y = a%x;
            System.out.println(x + " " + y);

            long answer;
            if(y < (x/2 + 1)){
                answer = y;
            }else{
                answer = x-y;
            }
                    
            output.write(x + " " + answer + "\n");
                
            
            // if (check) {
            //     output.write("YES" + "\n");
            // } else
            //     output.write("NO" + "\n");

        }

        output.flush();
        output.close();

    }

}