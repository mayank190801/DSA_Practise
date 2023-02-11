import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.OutputStreamWriter;
 
public class sameDifference {
    public static void main(String[] args) throws IOException {
 
        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int test = scan.nextInt();
        while (test-- > 0) {
 
            int size = scan.nextInt();
            long[] arr = new long[size];
            
            for (int i = 0; i < size; i++) {
                arr[i] = scan.nextLong();
            }
            
            HashMap<Long, Long> map = new HashMap<>();
            long count = 0;
            for(int i = 0; i < size; i++){
                long current = arr[i] - i;
                count += map.getOrDefault(current, 0L);
                map.put(current, map.getOrDefault(current, 0L) + 1L);
            }

            output.write(count + "\n");
        }
 
        output.flush();
        output.close();
 
    }
 
}