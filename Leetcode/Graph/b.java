package Leetcode.Graph;

public class b {
    public static void main(String[] args) {

    }

    public static int findJudge(int n, int[][] trust) {
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            int from = trust[i][0];
            int to = trust[i][1];

            a[from]++;
            b[to]++;
        }

        for (int i = 1; i <= n; i++) {
            if (a[i] == 0 && b[i] == n - 1)
                return i;
        }

        return -1;
    }

}
