import java.util.*;
import java.io.*;

public class second {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = scan.nextInt();
        while (test-- > 0) {
            int size = scan.nextInt();
            int[] arr = new int[size];

            int count = 0;
            for (int i = 0; i < size; i++) {
                arr[i] = scan.nextInt();
            }

            if (size == 1) {
                output.write("1" + "\n");
                continue;
            }

            // let's make a hashTable
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < size; i++) {
                if (map.containsKey(arr[i]))
                    map.put(arr[i], map.get(arr[i]) + 1);
                map.putIfAbsent(arr[i], 1);
            }

            // now put them back in the arr!
            int[] indexDiff = new int[map.size()];

            int index = 0;
            for (int key : map.keySet()) {
                indexDiff[index] = map.get(key);
                index++;
            }

            if (index == 1) {
                output.write(indexDiff[0] + "\n");
                continue;
            }

            // Inbuilt sort function, works pretty well though!
            // Implement it and it will all be fine remember that!
            // Just keep working hard
            Arrays.sort(indexDiff);
            int first = index - 1;
            int second = first - 1;

            while (second >= 0) {

                if (indexDiff[first] > 0) {
                    if (indexDiff[second] == 0) {
                        second--;
                        continue;
                    }
                    indexDiff[first]--;
                    indexDiff[second]--;
                } else {
                    first--;
                    second = first - 1;
                }

            }

            for (int i = 0; i < index; i++) {
                count += indexDiff[i];
            }

            output.write(count + "\n");
        }

        output.flush();
        output.close();
    }

}