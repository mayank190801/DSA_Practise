
import java.util.*;
import java.lang.*;
import java.io.*;


//METHOD - find the k and k+1 count for each range, and see which maximises the answer
//Simple but tricky for sure!


class Codechef {
    
    //let's figure this out for sure man
    public static void main(String[] args) throws java.lang.Exception{
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while(test --> 0){
            int n = sc.nextInt();
            int k = sc.nextInt();  //goal is to maximise this bad boi

            int[][] updates = new int[n][2];
            for(int i= 0; i < n; i++){
                updates[i][0] = sc.nextInt();
                updates[i][1] = sc.nextInt();
            }

            //now update the array bois
            int size = 100001;
            // int size = 20;
            int[] cake = new int[size];  //cake layer ofc
            for(int i = 0; i < n; i++){
                int l = updates[i][0];
                int r = updates[i][1];

                //now we have both l and r
                //make updates in that bad boi 
                cake[l-1] += 1;
                if(r == size) continue;
                cake[r] -= 1; 
            }

            int csum = 0;
            for(int i= 0; i < size; i++){
                csum += cake[i];
                cake[i] = csum;
            }

            //count of k and count of k+1
            int[] curr = new int[size];
            int[] next = new int[size];

            int current = 0;
            int plus = 0;
            
            int ans = 0;
            int cans = 0;

            for(int i= 0; i < size; i++){
                if(cake[i] == k) current++;
                curr[i] = current;

                if(cake[i] == k+1) plus++;
                next[i] = plus;                
            }

            cans = current;
            for(int i= 0; i < n; i++){

                int currans = cans;
                int l = updates[i][0];
                int r = updates[i][1];
                l--;
                r--;

                int countK = curr[r];
                if(l != 0){
                    countK -= curr[l-1];
                }

                int countKPlus = next[r];
                if(l != 0){
                    countKPlus -= next[l-1];
                }

                // System.out.println(countK + " " + countKPlus);

                currans += countKPlus;
                currans -= countK;

                ans = Math.max(ans, currans);
            }

            System.out.println(ans);
            // System.out.println(Arrays.toString(cake));
            // System.out.println(Arrays.toString(curr));
            // System.out.println(Arrays.toString(next));
            
        }

    }

    
}
