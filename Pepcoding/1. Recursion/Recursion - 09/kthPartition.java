import java.util.*;
import java.io.*;

public class kthPartition {
    public static void main(String[] args) {
        //partition according to given instances baby
        //how to solve this one
        int n = 4;
        int k = 3;

        ArrayList<Integer>[] partitions = new ArrayList[k];
        //this is how you make 
        for(int i = 0; i < k; i++){
            partitions[i] = new ArrayList<>();
        }
        
        partitions[0].add(1);
        solve(n,2,k,partitions);

    }

    public static void solve(int n, int current, int k, ArrayList<Integer> partitions[]){
        //let's solve it baby
        if(current > n){
            //then check
            for(int i= 0; i < partitions.length; i++){
                if(partitions[i].size() == 0) return;
            }
            //how to print is something really cool
            for(int i= 0; i < k; i++){
                System.out.print(partitions[i]);
            }
            System.out.println();
            return;
        }
        //pass it on to everyone
        for(int i= 0; i < k; i++){
            partitions[i].add(current);
            solve(n, current+1, k, partitions);
            partitions[i].remove(partitions[i].size()-1);
            if(partitions[i].size() == 0){
                return;
            }
        }

    }

}
