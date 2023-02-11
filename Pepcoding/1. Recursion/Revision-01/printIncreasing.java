public class printIncreasing {
    public static void main(String[] args) {
        printIncreasing(5);
    }

    //how to write a function to printIncreasing boss?
    public static void printIncreasing(int n){
        printIncreasing(1, n);
    }

    public static void printIncreasing(int i , int n){
        if(i > n) return;
        System.out.println(i);
        printIncreasing(i + 1, n);
    }

    //print decreasing is same as that bad boi for sure!! ( no worries )

    
}
