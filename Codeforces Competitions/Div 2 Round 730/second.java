import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.OutputStreamWriter;

public class second {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = scan.nextInt();
        while (test-- > 0) {

            int size = scan.nextInt();

            long[] arr = new long[size];

            long sum = 0;
            for(int i = 0 ; i < size ; i++){
                arr[i] = scan.nextLong();
            }

            for(long i : arr){
                sum += i;
            }

            long problem = sum%size;

            long answer = problem* (size - problem);

            output.write(answer + "\n");


            // if (check) {
            //     output.write("YES" + "\n");
            // } else
            //     output.write("NO" + "\n");

        }

        output.flush();
        output.close();

    }

    /*
}