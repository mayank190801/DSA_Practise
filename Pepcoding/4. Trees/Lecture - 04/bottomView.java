import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;


//recursive for homework bois
//traversals
//construction
//views

//next generic and path type questions for trees


public class bottomView{

    public static class Node {
        int data;
        Node left;
        Node right;
        Node() {}
        Node(int data) { this.data = data; }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    //pair for the win bois, keep it safe for the win
    public static class pair{
        Node node;
        int status = 0;

        pair(Node node, int status){
            this.node = node;
            this.status = status;
        }
    }
  
    //gotta code this piece of shit out and finish all those questions one day
    //let's code all the questions and build the logic first always 

    //you can use hashmap or sorting, that's totally upto you brother, i ain't gonna disturb you
    //this is pretty annoying as well as cool too

    //you can linkedlist pair, OR OR OR OR you can linkedlist on its own and kill this questions
    //USING LINKEDLIST for this question is god level technique

    static ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> answer = new ArrayList<>();
        //level order traversal(that too iterative, and then keeping the width for sure)
        Queue<pair> que = new ArrayDeque<>();
        //put treenode in here
        que.add(new pair(root, 0));
        int minWidth = 1;
        int maxWidth = -1;

        HashMap<Integer, Integer> map = new HashMap<>();
    
        while(!que.isEmpty()){
            int size = que.size();
            while(size -- > 0){
                pair top = que.poll();

                //now check for top.status for min and max
                map.put(top.status, top.node.data);
                //this is beauty of a code
                minWidth = Math.min(minWidth, top.status);
                maxWidth = Math.max(maxWidth, top.status);
        
                if(top.node.left != null){
                    que.add(new pair(top.node.left, top.status-1));
                }

                if(top.node.right != null){
                    que.add(new pair(top.node.right, top.status+1));
                }

            }

        }

        //now using hashmap we will play that game
        //this is something to think about for sure, pretty cool way tho
        for(int i = minWidth ; i <= maxWidth; i++){
            answer.add(map.get(i));
        }

        return answer;   
    }


}