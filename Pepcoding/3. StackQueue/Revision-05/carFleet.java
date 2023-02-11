import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class carFleet {

    public static void main(String[] args){

    }

     final double eps = 1e-10;
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> list = new ArrayList<>();
        for(int i= 0; i < position.length; i++){
            list.add(new Pair(position[i], speed[i]));
        }
        
        Collections.sort(list, (a,b) -> Integer.compare(a.a, b.a));
        //sorted upon position


        int n = position.length;
        double[] time = new double[n];
        for(int i=0; i < n; i++){
            time[i] = ((double)target - (double)list.get(i).a)/(double)list.get(i).b;
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        int answer = 0;
        for(int i = 0; i <= n; i++){
            double val  = i == n ? Double.MAX_VALUE : time[i];

            while(!stack.isEmpty() && (Math.abs(time[stack.peek()] - val) < eps || (val - time[stack.peek()] > 0)){  //fix this also once
                int idx = stack.pop();
                ans[idx] = i == n ? -1 : i;
            }

            stack.push(i);
        }

        for(int i = n-1; i >= 0; i--){
            if(ans[i] == -1) answer++;
        }
        
        return answer;
    }

    public class Pair{
        int a;
        int b;

        Pair(int a , int b){
            this.a =a ;
            this.b =b ;
        }
    }
}