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
            StringBuilder sb = new StringBuilder();
            long num = scan.nextLong();

            int count = 0;
            long x = 10;

            while (num >= x) {
                count += 9;
                x *= 10;
            }
            // now we would count where the number really is
            int digits = 0;
            while (x != 1) {
                digits++;
                x /= 10;
            }

            String currentNum = Long.toString(num);
            char random = currentNum.charAt(0);

            for (int i = 0; i < digits; i++) {
                sb.append(random);
            }

            long compare = Long.parseLong(sb.toString());

            if (num < compare) {
                count += random - '0';
                count--;
            } else {
                count += random - '0';
            }

            output.write(count + "\n");

        }

        output.flush();
        output.close();

    }

}