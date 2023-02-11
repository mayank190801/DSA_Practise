public class uglyNumbers {

    public static void main(String[] args) {
        
    }

    //divisible by 2 , 3 or 5 
    //0 is not an ugly number for sure
    public static boolean isUgly(int n) {
        if(n == 0) return false;
        
        while(n%2 == 0) n = n/2;
        while(n%3 == 0) n = n/3;
        while(n%5 == 0) n = n/5;
        
        return n == 1 ;
    }

    
}
