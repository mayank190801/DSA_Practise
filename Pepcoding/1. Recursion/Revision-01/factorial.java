public class factorial {
    public static void main(String[] args) {
        int fact = factorial(5);
        System.out.println(fact);
    }

    public static int factorial(int n){
        if( n == 1 ) return 1;
        return n * factorial(n - 1);
    }
    
    
}
