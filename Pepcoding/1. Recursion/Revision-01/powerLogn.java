public class powerLogn {

    public static void main(String[] args) {
        int val = power(2,10);
        System.out.println(val);
    }
     
    //is this power in logn?? (think think think think think)
    public static int power(int n, int t){  //return type for sure
        //how can you do this in logn?
        if(t == 0) return n;
        if(t == 1) return n;
        
        int x = power(n, t/2);  //half kr di call har baar!! (pretty smart no?);
        if(t%2 == 0){
            return x * x;
        }else{
            return x * x * n;
        }
    }

    
}
