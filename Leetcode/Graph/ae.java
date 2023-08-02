import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ae {
    public static void main(String[] args) {

    }

    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id,
            int level) {

        int n = friends.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < friends[i].length; j++) {
                int u = i;
                int v = friends[i][j];

                if (u > v)
                    continue;
                graph[u].add(v);
                graph[v].add(u);
            }
        }

        // now we know the start id, simple as that
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] vis = new int[n];
        vis[id] = 1;
        que.add(id);
        int depth = 0;
        ArrayList<Integer> sameLevel = new ArrayList<>();

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int curr = que.poll();
                if (depth == level)
                    sameLevel.add(curr);

                for (int edge : graph[curr]) {
                    if (vis[edge] != 1) {
                        vis[edge] = 1;
                        que.add(edge);
                    }
                }

            }
            depth++;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i : sameLevel) {
            for (String st : watchedVideos.get(i)) {
                map.putIfAbsent(st, 0);
                map.put(st, map.get(st) + 1);
            }
        }

        ArrayList<Pair> soln = new ArrayList<>();
        for (String key : map.keySet()) {
            soln.add(new Pair(key, map.get(key)));
        }

        Collections.sort(soln, (a, b) -> a.b - b.b);
        Collections.sort(soln, (a, b) -> a.a.compareTo(b.a));

        List<String> ans = new ArrayList<>();
        for (Pair p : soln) {
            ans.add(p.a);
        }
        return ans;
    }

    public static class Pair {
        String a;
        int b;

        public Pair(String a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Pair [a=" + a + ", b=" + b + "]";
        }
    }

}
