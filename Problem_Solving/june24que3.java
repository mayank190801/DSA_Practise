/**
 * june24que3
 */
public class june24que3 {

    public static void main(String[] args) {

    }

    // solving this decent problem in here
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        int xor = arr[0];
        for (int i = 1; i < pref.length; i++) {
            arr[i] = xor ^ pref[i];
            xor = xor ^ arr[i];
        }
        return arr;
    }

    // have to give proper hours to this

}