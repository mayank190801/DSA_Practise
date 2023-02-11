import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.OutputStreamWriter;

public class third {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long num = 1000000000000L;
        // now i have to make a set with all the cubes in it!
        Set<Long> cubes = new HashSet<>();
        for (long i = 1; i * i * i <= num; i++) {
            cubes.add(i * i * i);
        }

        int test = scan.nextInt();
        while (test-- > 0) {
            long N = scan.nextLong();

            // now just do that simple code bruh
            boolean flag = false;
            for (long i = 1; i * i * i <= N; i++) {
                if (cubes.contains(N - i * i * i)) {
                    output.write("YES" + "\n");
                    flag = true;
                    break;
                }
            }

            if (!flag)
                output.write("NO" + "\n");
        }

        output.flush();
        output.close();
    }

}