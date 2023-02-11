import java.io.*;
import java.util.*;

public class first {

    public static void swap(char[] num, int f, int s) {
        char temp = num[f];
        num[f] = num[s];
        num[s] = temp;
    }

    // next perm algorithm
    public static void nextPerm(char[] num, int k) {

        int size = num.length;
        // we have it now under controlled

        while (k-- > 0) {

            int ii = -1, jj = -1;

            for (int i = 0; i < size - 1; i++)
                if (num[i] - '0' < num[i + 1] - '0')
                    ii = i;

            for (int i = ii + 1; i < size; i++)
                if (num[i] > num[ii])
                    jj = i;

            swap(num, ii, jj);

            int last = size - 1;
            for (int i = 0; i < (size - (ii + 1)) / 2; i++)
                swap(num, ii + i + 1, last - i);

            System.out.println(Arrays.toString(num));

        }

    }

    // minimum swaps calculator algorithm
    public static int minSwap(char[] prev, char[] curr) {

        int count = 0;
        for (int i = 0; i < curr.length; i++) {
            char current = curr[i];
            for (int j = i; j < curr.length; j++) {
                if (prev[j] == current) {
                    bringFront(prev, i, j);
                    break;
                }
                count++;
            }
        }

        return count;
    }

    // Bring to the front algo!
    public static void bringFront(char[] prev, int want, int orig) {
        for (int i = orig; i > want; i--) {
            swap(prev, i, i - 1);
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = "059";
        char[] cOrig = s.toCharArray();
        char[] c = s.toCharArray();

        nextPerm(c, 5);
        System.out.println(minSwap(cOrig, c));

        output.flush();
        output.close();
    }

}

// Review this code later and see how it is better than yours!
// Pretty much same, he used more while loops where as i prefer for loop most
// of the times

/*
 * class Solution { public int getMinSwaps(String num, int k) { char[] arr =
 * num.toCharArray(); for (int i = 0; i < k; i++) { nextPermutation(arr); }
 * char[] ori = num.toCharArray(); return CountSteps(ori, arr, arr.length); }
 * 
 * public void nextPermutation(char[] nums) { if (nums.length == 0) return; int
 * len = nums.length; for (int i = len - 1; i >= 1; i--) { if (nums[i] > nums[i
 * - 1]) { reverse(nums, i); for (int j = i; j < len; j++) { if (nums[j] >
 * nums[i - 1]) { swap(nums, i - 1, j); return; } } } } reverse(nums, 0); }
 * 
 * public void reverse(char[] nums, int i) { int j = nums.length - 1; while (i <
 * j) { swap(nums, i, j); i++; j--; } }
 * 
 * public void swap(char[] nums, int i, int j) { char temp = nums[i]; nums[i] =
 * nums[j]; nums[j] = temp; }
 * 
 * private int CountSteps(char []s1, char[] s2, int size) { int i = 0, j = 0;
 * int count = 0;
 * 
 * while (i < size) { j = i;
 * 
 * while (s1[j] != s2[i]) { j += 1; } while (i < j) { swap(s1, j, j - 1); j -=
 * 1; count++; } i++; } return count; } }
 * 
 */