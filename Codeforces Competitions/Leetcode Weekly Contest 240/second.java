import java.io.*;
import java.util.*;

public class second {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] nums1 = { 55, 30, 5, 4, 2 };
        int[] nums2 = { 100, 20, 10, 10, 5 };

        int currentNum = 0;
        int max = -1;
        for (int i = 0; i < nums1.length; i++) {
            currentNum = i;
            while (nums1[i] <= nums2[currentNum]) {
                if (currentNum - i > max) {
                    max = currentNum - i;
                }
                if (currentNum == nums2.length - 1) {
                    break;
                }
                currentNum++;
            }
        }

        if (max == -1)
            System.out.println(0);
        else
            System.out.println(max);

        output.flush();
        output.close();
    }

}