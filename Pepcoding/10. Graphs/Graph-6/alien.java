import java.lang.reflect.Array;
import java.util.*;

public class alien {
    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "ea", "er", "ett", "rftt"};
        alienOrder(words);
    }

    //finding the alien order in this graph
    public static String alienOrder(String[] words) {

        ArrayList<Set<Integer>> graph = new ArrayList<>();
        Map<Character, Integer> mapping = new HashMap<>();
        Map<Integer, Character> oppo = new HashMap<>();

        //we are saved on this one for sure for the rest of the code
        for(String word : words){
            for(char ch : word.toCharArray()){
                if(!mapping.containsKey(ch)){
                    mapping.put(ch, graph.size());
                    oppo.put(graph.size(), ch);
                    graph.add(new HashSet<>());
                }
            }
        }

        //only 10^4 is there, simple as that
        for(int i = 0; i < words.length - 1; i++){
            for(int j = i + 1; j < words.length; j++){
                String f = words[i];
                String s = words[j];

                //for this now
                for(int k = 0; k < Math.min(f.length(), s.length()); k++){
                    if(f.charAt(k) != s.charAt(k)){
                        int posOne = mapping.get(f.charAt(k));
                        int posTwo = mapping.get(s.charAt(k));
                        graph.get(posOne).add(posTwo);
                        break;
                    }
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[graph.size()];
        for(int i = 0; i < graph.size(); i++){
            if(vis[i] != 1){
                topoSort(i, vis, graph, stack);
            }
        }

        ArrayList<Integer> order = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            int num = stack.pop();
            sb.append(oppo.get(num));
        }

        return sb.toString();
    }

    public static void topoSort(int curr, int[] vis, ArrayList<Set<Integer>> graph, Stack<Integer> st){
        vis[curr] = 1;
        for(int edge : graph.get(curr)){
            if(vis[edge] != 1){
                topoSort(edge, vis, graph, st);
            }
        }

        st.add(curr);
    }
}
