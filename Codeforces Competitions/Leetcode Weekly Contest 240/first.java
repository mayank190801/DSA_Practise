import java.io.*;
import java.util.*;

public class first {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[][] logs = { { 2008, 2026 }, { 2004, 2008 }, { 2034, 2035 }, { 1999, 2050 }, { 2049, 2050 }, { 2011, 2035 },
                { 1966, 2033 }, { 2044, 2049 } };

        int[][] update = new int[2 * logs.length][2];

        int count = 0;
        for (int i = 0; i < logs.length; i++) {
            update[count][0] = logs[i][0];
            update[count][1] = 0;

            count++;
            update[count][0] = logs[i][1];
            update[count][1] = 1;
            count++;
        }

        Arrays.sort(update, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                if (first[0] != second[0]) {
                    return Integer.compare(first[0], second[0]);
                } else {
                    return Integer.compare(second[1], first[1]);
                }

            }
        });

        // now max number of people before a certain year
        int max = Integer.MIN_VALUE;
        int year = 1;
        int currentCount = 0;

        for (int i = 0; i < update.length; i++) {
            if (update[i][1] == 0) {
                currentCount++;
                if (max < currentCount) {
                    max = currentCount;
                    year = update[i][0];
                }
            } else {
                currentCount--;
            }
        }

        System.out.println(year);

        output.flush();
        output.close();
    }

}