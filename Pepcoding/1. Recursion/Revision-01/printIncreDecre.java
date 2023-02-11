public class printIncreDecre {
    public static void main(String[] args) {
        incDec(5, 10);
    }

    public static void incDec(int i, int end){
        if(i > end) return;

        System.out.println(i);
        incDec(i + 1, end);
        System.out.println(i);
    }
    
}
