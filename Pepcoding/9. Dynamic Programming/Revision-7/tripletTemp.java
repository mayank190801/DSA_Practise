import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class tripletTemp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        solve(N);
    }

    public static void solve(int N){
        //n could range from 1 to 300 (simple as that)
        int n = N;
        int max = n/3*2;
        if (n%3==2)
            max++;
        int sn = n;
        if (n%3==1)
            sn--;
        System.out.println(max+1);
        int first = max;
        for (int i = (max+1)/2; i >= 0; i--) {
            System.out.println(first+" "+i+" "+(n-i-first));
            first--;
        }
        for (int i = sn-first-1; first >= 0; i--) {
            System.out.println(first+" "+i+" "+(n-i-first));
            first--;
        }

    }

}
