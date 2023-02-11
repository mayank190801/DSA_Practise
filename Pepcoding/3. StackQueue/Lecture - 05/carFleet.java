import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> list = new ArrayList<>();
        for(int i= 0; i < position.length; i++){
            list.add(new Pair(position[i], speed[i]));
        }
        
        Collections.sort(list, (a,b) -> Integer.compare(a.a, b.a));
        //now we have got everything sorted 
        int answer= 0;
        int currMin = 0;

        Stack<Double> minTime = new Stack<>(); 

        for(int i = 0; i < list.size(); i++){

            double curr = (double)(target-list.get(i).a)/ (double)list.get(i).b;
            if(minTime.isEmpty()){
                minTime.push(curr);
            }else{
                double past = minTime.peek();
                if(curr >= past){
                    minTime.push(curr);
                }else{
                    while(!minTime.isEmpty()){
                        minTime.pop();
                    };

                    answer++;
                    minTime.push(curr);
                }
            }
        }

        if(!minTime.isEmpty()) answer++;
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