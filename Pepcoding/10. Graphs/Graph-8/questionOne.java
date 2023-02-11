import java.util.Scanner;

public class questionOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test --> 0){
            int n = sc.nextInt();

            if((n/2)%2 == 1){
                System.out.println("Not possible");
                continue;
            }

            int[] arr = new int[n];
            int sumOdd = 0;
            for(int i = 0; i < n/2; i++){
                arr[i] = (i*2) + 1;
                sumOdd += arr[i];
            }

            int sumEven = 0;
            for(int i = 0; i < n/2 - 1; i++){
                arr[(n/2) + i] = arr[i] - 1;
                sumEven += arr[(n/2) + i];
            }

            arr[n - 1] = sumOdd - sumEven;
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


}
