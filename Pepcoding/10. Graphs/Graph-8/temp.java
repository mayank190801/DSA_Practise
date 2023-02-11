import java.util.Scanner;

public class temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num != 0){
            System.out.println(num & 1);
            num = num >> 1; //this works for diving by 2
        }
    }
}
