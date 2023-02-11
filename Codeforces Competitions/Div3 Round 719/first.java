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

            int size = scan.nextInt();
            scan.nextLine();
            String s = scan.nextLine();

            char[] c = s.toCharArray();
            int[] started = new int[26];

            int currentChar = c[0];
            started[currentChar - 'A'] = 1;

            boolean check = true;

            for (int i = 1; i < size; i++) {

                if (started[c[i] - 'A'] != 0) {
                    if (c[i] != currentChar) {
                        check = false;
                        break;
                    }
                } else {
                    currentChar = c[i];
                    started[currentChar - 'A'] = 1;
                }

            }

            if (check) {
                output.write("YES" + "\n");
            } else
                output.write("NO" + "\n");

        }

        output.flush();
        output.close();

    }

}