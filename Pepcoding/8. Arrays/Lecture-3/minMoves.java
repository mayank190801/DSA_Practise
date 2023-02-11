public class minMoves {

    //METHOD - 1 O(nlogn)
    //sort them, and make each equal one by one

    //METHOD - 2 O(n)
    //I REMEMBER THIS QUESTION!!! DECREMENT 1 ELEMENT BY 1 per step!!
    public int minMoves(int[] nums) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for(int i : nums) min = Math.min(i, min);
        for(int i : nums) count += i - min;
        return count;
    }

}
