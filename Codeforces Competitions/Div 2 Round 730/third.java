import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;


import java.io.OutputStreamWriter;

public class third {

    public static double count;
    public static double eps = 1e-9;

    public static void solve(double c , double  m , double p, double v, double curr){

        //only when this possible
        
        count += p*curr;
       
        if(m > Math.abs(0-eps)){
            //solve this and push it further
            if(m > Math.abs(v-eps)){
                
                if( c < Math.abs(0-eps)){
                    p += v;
                }else{
                    c += v/2;
                    p += v/2;
                }

                solve(c, m-v, p, v, curr*m);
            }else{

                if( c < Math.abs(0-eps)){
                    p += m;
                }else{
                    c += m/2;
                    p += m/2;
                }

                solve(c, 0, p, v, curr*m);
            }            
        }

        if( c > Math.abs(0-eps) ){

            if(c > Math.abs(v-eps)){
                double x = v;
                if( m < Math.abs(0-eps)){
                    p += v;
                }else{
                    m += v/2;
                    p += v/2;
                }

                solve(c-v, m, p, v, curr*c);
            }else{

                if( m < Math.abs(0-eps)){
                    p += c;
                }else{
                    m += c/2;
                    p += c/2;
                }

                solve(0, m, p, v, curr*c);
            }
        }
    }
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = scan.nextInt();
        while (test-- > 0) {

            double c , m , p, v;
            
            c = scan.nextDouble();
            m = scan.nextDouble();
            p = scan.nextDouble();
            v = scan.nextDouble();

            System.out.println(eps);

            count = 0;
            double num = 1;
            solve(c,m,p,v, num);
            
            System.out.println(count);

            // if (check) {
            //     output.write("YES" + "\n");
            // } else
            //     output.write("NO" + "\n");

        }

        output.flush();
        output.close();

    }

}