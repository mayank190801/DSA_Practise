import java.util.ArrayList;
import java.util.*;
import java.io.*;


public class C {
    public static void main(String[] args) {
        
    }

    public static int largestCombination(int[] candidates) {
        int[] bit = new int[32];
        for(int i : candidates){
            int idx = 0;
            while(i != 0){
                if((i & 1) == 1){
                    bit[idx]++;
                }
                idx++;
                i = i >> 1;
            }            
        }

        int max = 0;
        for(int i : bit){
            max = Math.max(max, i);
        }

        return max;
    }
    
}
