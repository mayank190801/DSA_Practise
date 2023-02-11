import java.util.*;
import java.io.*;
import java.awt.Point;


public class splittingInto{
    public static void main(String[] args){

        String s = "0090089";
        List<Long> list = new ArrayList<>();
            
        //passing base number eases up the question for sure
        for(int i = 0; i < s.length()-1; i++){
            long curr = Long.parseLong(s.substring(0, i));
            list.add(curr);
            solve(s, i+1, list);
            list.remove(list.size()-1);
        }

    }

    public static void solve(String s, int idx , List<Long> list){

        if(idx == s.length()){
            System.out.println(list);
            return;
        }

        for(int i = idx; i < s.length(); i++){
            long curr = Long.parseLong(s.substring(idx, i+1));
            if(list.get(list.size()-1) - curr == 1){
                list.add(curr);
                solve(s, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }

}
