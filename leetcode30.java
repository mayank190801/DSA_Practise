public class leetcode30 {
    public static void main(String[] args) {
        String first = "";
        String second = "a";

        System.out.println(minDistance(first, second));
    }

    //let's write the recursive
    public static int minDistance(String word1, String word2) {
            return solve(word1, word2, word1.length() - 1, word2.length() - 1);
        }

        public static int solve(String word1, String word2, int fidx, int sidx) {
            if (fidx == -1 && sidx == fidx) return 0;
            if (fidx == -1 || sidx == -1) return Math.max(fidx + 1, sidx + 1);
            int val = 1 + Math.min(solve(word1, word2, fidx - 1, sidx - 1), Math.min(solve(word1, word2, fidx - 1, sidx), solve(word1, word2, fidx, sidx - 1)));
            if (word1.charAt(fidx) == word2.charAt(sidx)) {
                val = Math.min(val, solve(word1, word2, fidx - 1, sidx - 1));
            }
            return val;
    }


}

