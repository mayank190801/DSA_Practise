public class client{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        heap myheap = new heap(arr);
        myheap.add(-1);
        myheap.add(8);
        myheap.display();
    }

}