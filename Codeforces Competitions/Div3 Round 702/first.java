import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = scan.nextInt();
            }

            int min, max;
            int count = 0;
            for (int i = 0; i < size - 1; i++) {
                min = Math.min(arr[i], arr[i + 1]);
                max = Math.max(arr[i], arr[i + 1]);

                while (min * 2 < max) {
                    count++;
                    min = min * 2;
                }

            }

            output.write(count + "\n");

        }

        output.flush();
        output.close();
    }

}