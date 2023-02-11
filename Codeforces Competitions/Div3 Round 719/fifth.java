import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import java.io.OutputStreamWriter;

public class fifth {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = scan.nextInt();

        while (test-- > 0) {
            StringBuilder sb = new StringBuilder();

            int n = scan.nextInt();
            scan.nextLine();
            String s = scan.nextLine();
            char[] c = s.toCharArray();

            int total = 0;
            for (char star : c) {
                if (star == '*')
                    total++;
            }

            int index = 0;
            int end = c.length - 1;

            int minMoves = 0;
            int majority = 0;

            boolean yes = false;
            for (int i = 0; i < c.length; i++) {
                if (majority > (total / 2)) {
                    yes = true;
                    break;
                }
                if (c[i] == '*') {
                    majority++;
                } else {
                    minMoves += majority;
                }
                index++;
            }

            majority = 0;
            if (yes) {
                for (int i = c.length - 1; i >= index; i--) {
                    if (c[i] == '*') {
                        majority++;
                    } else {
                        minMoves += majority;
                    }
                }

            }

            output.write(minMoves + "\n");
        }

        output.flush();
        output.close();

    }

}