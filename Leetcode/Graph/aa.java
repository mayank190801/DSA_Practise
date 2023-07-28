import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aa {
    public static void main(String[] args) {

    }

    // let's solve this bad boy for sure
    // still some error, figure out why those are happening
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> mapRev = new HashMap<>();

        for (String s : recipes) {
            map.putIfAbsent(s, map.size());
            mapRev.putIfAbsent(map.size() - 1, s);
        }
        for (String s : supplies) {
            map.putIfAbsent(s, map.size());
            mapRev.putIfAbsent(map.size() - 1, s);
        }
        for (List<String> temp : ingredients) {
            for (String s : temp) {
                map.putIfAbsent(s, map.size());
                mapRev.putIfAbsent(map.size() - 1, s);
            }
        }
        // so we have this right
        int n = map.size();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        for (int i = 0; i < recipes.length; i++) {
            List<String> curr = ingredients.get(i);
            indegree[i] = curr.size();
            for (String s : curr) {
                graph[map.get(s)].add(i);
            }
        }

        int[] vis = new int[n];
        List<String> ans = new ArrayList<>();
        ArrayDeque<Integer> que = new ArrayDeque<>();

        for (String str : supplies) {
            int idx = map.get(str);
            vis[idx] = 1;
            que.add(idx);
        }

        while (!que.isEmpty()) {
            int curr = que.poll();
            for (int edge : graph[curr]) {
                indegree[edge]--;
                if (indegree[edge] == 0) {
                    que.add(edge);
                    ans.add(mapRev.get(edge));
                }
            }
        }

        return ans;
    }

}
