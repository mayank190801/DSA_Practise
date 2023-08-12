import java.util.ArrayDeque;

public class ag {
    public static void main(String[] args) {

    }

    // using DSU, we would have known that their is only one parent for this use
    // case - but DSU is something I am not very comfortable with
    // More problems might help, but nuhh
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] par = new int[n];
        for (int i = 0; i < n; i++) {
            int u = leftChild[i];
            int v = rightChild[i];
            if (u != -1)
                par[u] = 1;
            if (v != -1)
                par[v] = 1;
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (par[i] == 0 && root != -1)
                return false;
            if (par[i] == 0)
                root = i;
        }
        if (root == -1)
            return false;

        int[] vis = new int[n];
        int cnt = 0;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {
            int curr = que.poll();
            if (curr == -1)
                continue;
            if (vis[curr] == 1)
                return false;
            vis[curr] = 1;
            cnt++;
            int left = leftChild[curr];
            int right = rightChild[curr];
            que.add(left);
            que.add(right);
        }

        return cnt == n;
    }

}
