import java.io.*;
import java.util.*;

public class first {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = scan.nextInt();
        while (test-- > 0) {

            long A = scan.nextLong();
            long B = scan.nextLong();

            if (A % B == 0) {
                output.write("NO" + "\n");
            } else
                output.write("NO" + "\n");

            // output.write(count + "\n");

        }

        output.flush();
        output.close();
    }

}