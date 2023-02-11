import java.util.Scanner;

import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int count = 0;
        Arrays.sort(arr);
        int num = arr[n-k];
        for(int i= 0; i < n; i++){
            if(arr[i] > 0 & arr[i] >= num) count++;
        }

        System.out.println(count);
        

    }
}
