import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import java.io.OutputStreamWriter;

public class second {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = scan.nextInt();

        while (test-- > 0) {

            int n = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();

            boolean pos = false;

            if(n == 1){
                pos = true;
            }
            
            if(b == 1){
                pos = true;
            }else if(a == 1){   
                if(n%b  == 1)
                    pos = true;
            }else{
                //now this case is very important
                while(true){

                    if(n == 1){
                        pos = true;
                        break;
                    }

                    if(n%a == 0){
                        n = n/a;
                    }else{
                        if(n > b){
                            n = n - b;
                        }else{
                            break;
                        }
                    }
                }
            }

            String answer;
            if(pos)
                answer = "Yes";
            else
                answer = "No";


            output.write(answer + "\n");
        }

        output.flush();
        output.close();

    }

}