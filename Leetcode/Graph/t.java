package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class t {
    public static void main(String[] args) {

    }

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
