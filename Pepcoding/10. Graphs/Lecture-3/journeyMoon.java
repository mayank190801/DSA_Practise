import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        // System.out.println(astronaut);
        //List, List, for the connections is given for sure
        //i need to convert astronaut to some proper form for sure
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i= 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i= 0; i < astronaut.size(); i++){
            int u = astronaut.get(i).get(0);
            int v = astronaut.get(i).get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        

        ArrayList<Long> list = new ArrayList<>();
        int[] vis = new int[n];

        for(int i= 0; i < n; i++){
            if(vis[i] == 0){
                long count = counter(n, graph, vis, i);
                list.add(count);
            }
        }

        long answer = 0;
        long sum = 0;

        //we can do this part in cojoined with the above part, rather than using arraylist, we could 
        //do it on our own without any hassle for sure!! ( pretty cool for sure )!! 
        for(int i= list.size() - 2; i >= 0; i--){  //fix this portion for sure
            answer += list.get(i) * sum;
            sum += list.get(i);
        }

        return (int) answer;
    }

    public static long counter(int n, ArrayList<Integer>[] graph, int[] vis, int src){

        vis[src] = 1;
        long count = 0;
        for(int astro : graph[src]){
            if(vis[astro] == 0){
                count += counter(n, graph, vis, astro);
            }
        }

        return count + 1;
    }

}

public class journeyMoon {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        System.out.println("fuck");
        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
