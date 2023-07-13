package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class t {
    public static void main(String[] args) {

    }

    // bfs simple solution
    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashSet<Integer> set = new HashSet<>();
        Map<Integer, Node> map = new HashMap<>();
        ArrayDeque<Node> que = new ArrayDeque<>();
        map.put(node.val, new Node(node.val));
        que.add(node);
        while (!que.isEmpty()) {
            Node curr = que.poll();
            if (set.contains(curr.val))
                continue;
            set.add(curr.val);
            Node tcurr = map.get(curr.val);
            for (Node edges : curr.neighbors) {
                map.putIfAbsent(edges.val, new Node(edges.val));
                tcurr.neighbors.add(map.get(edges.val));
                que.add(edges);
            }
        }
        return map.get(node.val);
    }

    // let's try recursive dfs solution or something
    // solve it without using set and think on paper for more clear usage of data
    // structures
    public static Node cloneGraphDFS(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public static Node dfs(Node curr, HashMap<Integer, Node> map) {
        Node ncurr = new Node(curr.val);
        map.putIfAbsent(ncurr.val, ncurr);
        for (Node edges : curr.neighbors) {
            if (map.containsKey(edges.val)) {
                ncurr.neighbors.add(map.get(edges.val));
            } else {
                Node get = dfs(edges, set, map);
                ncurr.neighbors.add(get);
            }
        }
        return ncurr;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
