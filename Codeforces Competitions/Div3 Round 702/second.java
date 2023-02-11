import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = scan.nextInt();
            }

            int[] numRemainder = new int[3];

            for (int i = 0; i < size; i++) {
                numRemainder[arr[i] % 3]++;
            }

            int count = 0;
            int balance = size / 3;

            boolean flag = true;
            int index = 0;
            while (flag) {

                if (numRemainder[0] == numRemainder[1] && numRemainder[1] == numRemainder[2]) {
                    break;
                }

                if (numRemainder[index] > balance) {
                    count++;
                    numRemainder[index]--;
                    numRemainder[(index + 1) % 3]++;
                }

                index++;
                index %= 3;
            }

            output.write(count + "\n");

        }

        output.flush();
        output.close();
    }

}