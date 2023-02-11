public class printReverse {
    public static void main(String[] args) {
        int[] arr = {1,23,4,5,6};
        displayArrReverse(arr, 0);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        if(idx >= arr.length) return;
        System.out.println(arr[arr.length - idx - 1]);
        displayArrReverse(arr, idx + 1);
    }
    
}
