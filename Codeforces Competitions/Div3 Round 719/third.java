import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.OutputStreamWriter;

public class third {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = scan.nextInt();

        while (test-- > 0) {
            StringBuilder sb = new StringBuilder();

            int n = scan.nextInt();

            if (n == 1) {
                output.write(1 + "\n");
                continue;
            }

            if (n == 2) {
                output.write(-1 + "\n");
                continue;
            }

            int numOdd;
            if (n % 2 == 1) {
                numOdd = ((n * n) / 2) + 1;
            } else
                numOdd = (n * n) / 2;

            int x = 1;
            int index = 0;
            boolean once = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    index++;
                    if (index > numOdd && once) {
                        once = false;
                        x = 2;
                    }
                    output.write(x + " ");
                    x += 2;
                }
                output.write("\n");
            }

        }

        output.flush();
        output.close();

    }

}