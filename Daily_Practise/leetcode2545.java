import java.util.Arrays;

public class leetcode2545 {
    public static void main(String[] args) {

    }

    public int[][] sortTheStudents(int[][] score, int k) {
        //sort on the basis of the ith index
        Arrays.sort(score, (a, b) -> {
            return a[k] - b[k];
        });

        return score;
    }
}
