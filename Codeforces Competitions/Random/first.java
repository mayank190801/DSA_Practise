import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class first {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        int test = scan.nextInt();

        while (test-- > 0) {

            int size = scan.nextInt();

            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = scan.nextInt();
            }

            if (size == 1) {
                list.add(1);
                continue;
            }

            int f = 0;
            int s = 1;

            while (s < size) {

                if (arr[f] == -1) {
                    f++;
                    s++;
                    continue;
                }

                if (arr[s] == -1) {
                    s++;
                    continue;
                }

                if (arr[f] == arr[s]) {
                    s++;
                } else {
                    arr[f] = -1;
                    arr[s] = -1;

                    f++;
                    s = f + 1;
                }

            }

            int count = 0;
            for (int c : arr) {
                if (c == -1) {
                    count++;
                }
            }

            list.add(size - count);
        }

        for (int cham : list) {
            System.out.println(cham);
        }

    }

}
