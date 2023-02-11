import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.OutputStreamWriter;

public class fourth {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = scan.nextInt();
        while (test-- > 0) {

            int size = scan.nextInt();

            int count = 0;

            for (int i = 0; i < size; i++) {
                int x = scan.nextInt();
                if ((x - 1) == i)
                    count++;
            }

            if (count == 0 || count == 1) {
                output.write(0 + "\n");
            } else {
                count--;
                long sum = (count * (count + 1)) / 2;
                output.write(sum + "\n");
            }

        }

        output.flush();
        output.close();

    }

}