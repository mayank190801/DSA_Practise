package Leetcode.Graph;

import java.util.ArrayList;
import java.util.List;

public class c {
    public static void main(String[] args) {

    }

    // simply keep solving problems
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] count = new int[n];
        for (List<Integer> curr : edges) {
            int from = curr.get(0);
            int to = curr.get(1);

            count[to]++;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (count[i] == 0)
                ans.add(i);
        }

        return ans;
    }

}
