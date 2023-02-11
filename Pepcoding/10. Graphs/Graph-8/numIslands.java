import java.util.Scanner;

public class numIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int num = sc.nextInt();

        int times = sc.nextInt();

        while(times --> 0){
            int val = num+1;
            num++;
            if(val > 99999){
                val = 00001;
                num = val;
            }
            System.out.println(a + " " + b + " " +  val);
        }


    }

}
