import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class knighDialer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int ans = knightDialer(n);  //thousands and thousands of rupees for sure
        System.out.println(ans);

    }

    //SIR SOLUTION IS PRETTY DOPE FOR SURE


    //MY SOLVE PRETTY NASTY!!!
    //Could have used 3D dp and horse jumps like we used to with 2D array mapping
    //sounds pretty cool for sure, but i think my solution was easier to implement
    public static int knightDialer(int n) {

        //keep swich the names of these array for easier work
        long[] curr = new long[10];
        long[] past = new long[10];
        long mod = 1_000_000_007L;

        Arrays.fill(past, 1L);  //some initialisation

        ArrayList<ArrayList<Integer>> jumps = new ArrayList<>();
        for(int i= 0; i <= 9; i++){
            jumps.add(new ArrayList<>());
        }

        //could have used the opposite feature
        jumps.get(0).add(4);
        jumps.get(0).add(6);
        jumps.get(1).add(6);
        jumps.get(1).add(8);
        jumps.get(2).add(7);
        jumps.get(2).add(9);
        jumps.get(3).add(4);
        jumps.get(3).add(8);
        jumps.get(4).add(3);
        jumps.get(4).add(9);
        jumps.get(4).add(0);
        jumps.get(6).add(1);
        jumps.get(6).add(7);
        jumps.get(6).add(0);
        jumps.get(7).add(2);
        jumps.get(7).add(6);
        jumps.get(8).add(1);
        jumps.get(8).add(3);
        jumps.get(9).add(2);
        jumps.get(9).add(4);


        //so many manual additions for sure
        for(int i = 2; i <= n; i++){
            //at each jump
            for(int j = 0; j <= 9; j++){
                ArrayList<Integer> list = jumps.get(j);
                curr[j] = 0;  //refresh no?
                for(int k : list){
                    curr[j] = (curr[j] + past[k])%mod;
                }
            }

            // System.out.println(Arrays.toString(curr));
            long[] temp = curr;
            curr = past;
            past = temp;
        }

        //then end mein saare past ke calculate kr lo
        // System.out.println(Arrays.toString(past));
        long ans = 0;
        for(int i = 0; i <= 9; i++){
            if(i == 5 && n > 1) continue;
            ans = (ans + past[i])%mod;
        }
    
        return (int)(ans%mod);
    }

    
    
}
