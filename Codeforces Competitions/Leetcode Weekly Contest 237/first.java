import java.io.*;
import java.util.*;

public class first {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s = scan.nextLine();
        int[] costs = {1,2,3,4,5};
        int coins = 7;

        Arrays.sort(costs);
        int count = 0;
        for(int i = 0 ; i < costs.length ; i++){
            if(coins >= costs[i]){
                coins -= costs[i];
                count++;
            }else{
                break;
            }
        }
        return count;

        output.flush();
        output.close();
    }

}