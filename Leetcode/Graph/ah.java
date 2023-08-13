public class ah {
    public static void main(String[] args) {
    }

    // habit is the best thing to do!
    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int hr : hours) {
            if (hr >= target)
                ans++;
        }
        return ans;
    }

}
