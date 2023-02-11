import java.io.*;
import java.util.*;

public class first {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int n = 34;
        int k = 6;

        while (n >= k) {
            sum += (n % k);
            n = n / k;
        }

        sum += n;

        System.out.println(sum);

        output.flush();
        output.close();
    }

}