import java.util.*;
import java.io.*;
import java.awt.Point;


public class splitFibo{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String fibo = sc.nextLine();
        
        //don't worry about optimisation and all shit

        List<Integer> list = new ArrayList<>();
        solve(fibo, 0, list);
        // System.out.println(list);        
        return list
    }


    //my version of the code lol
    //not bad, but a lil tricky for the edge case, which is causing slight error
    public static boolean solve(String fibo, int idx, List<Integer> list){

        if(idx == fibo.length()){
            if(list.size() >= 3){
                System.out.println(list);
                return true;
            }
            return false;
        }
     
        boolean res= false;
        for(int i = idx; i < fibo.length(); i++){

            if(fibo.charAt(idx) == '0' && i != idx) break;
            long curr = Long.parseLong(fibo.substring(idx, i+1));
            if(curr > Integer.MAX_VALUE){
                return res;
            }

            if(list.size() < 2){
                list.add((int)curr);
                res = res || solve(fibo, i+1, list);
                if(res) return true;
                list.remove(list.size()-1);
            }else{
                //we would have to perform a check operation on this 
                if(curr == (list.get(list.size()-1) + list.get(list.size()-2))){
                    list.add((int)curr);
                    res = res || solve(fibo, i+1, list);
                    if(res) return true;
                    list.remove(list.size()-1);
                }
            }

        }

        return res;

    }


    //let's write sir version of cde
    // public static boolean fibonacciSeq(String str, int idx, int f0, int f1){

    //     //move through and perform these operations, simple as that
    //     //let's tryna solve these questions, no matter what
    //     for(int i = idx; i < str.length(); i++){
    //         int current = Integer.parseInt(str.substring(idx, i+1));
    //         if(current == f0 + f1){

    //         }
    //     }
    // }





}
