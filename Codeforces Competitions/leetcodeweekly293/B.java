import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bottom = sc.nextInt();
        int top = sc.nextInt();
        int[] arr = {7,6,8};
        int ans = maxConsecutive(bottom, top, arr);
        System.out.println(ans);
    }
    

    public static int maxConsecutive(int bottom, int top, int[] special) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : special){
            list.add(i);
        }

        int temp = bottom;
        bottom = top;
        top = temp;

        Collections.sort(list);
        

        //after this simply take which under 
        ArrayList<Integer> updated = new ArrayList<>();
        updated.add(top);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) <= bottom && list.get(i) >= top) updated.add(list.get(i));
        }
        updated.add(bottom);

        int n = updated.size();

        int max = 0;
        for(int i = 1; i < updated.size() - 2; i++){
            int get = Math.abs(updated.get(i) - updated.get(i + 1)) - 1;
            max = Math.max(max, get);
        }

        //edge cases on your own 
        // System.out.println(updated);
        
        int diff = Math.abs(updated.get(0) - updated.get(1));
        max = Math.max(max, diff);

        diff = Math.abs(updated.get(n-2) - updated.get(n -1));
        max = Math.max(max, diff);

        return max;
    }
}
