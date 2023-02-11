import java.util.ArrayList;

public class mazePath {
    public static void main(String[] args) {
        ArrayList<String> inp = getMazePaths(0, 0, 2, 2);
        System.out.println(inp);
        getMazePaths(0, 0, 2, 2, new StringBuilder());
    }

    //let's keep revising the questions for the better of everyone - 
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column

    //RETURN TYPES - perfect bois!!
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        if(sr < dr){
            ArrayList<String> recAns = getMazePaths(sr + 1, sc, dr, dc);
            for(String str : recAns){
                ans.add('h' + str);
            }
        }

        if(sc < dc){
            ArrayList<String> recAns = getMazePaths(sr, sc + 1, dr, dc);
            for(String str : recAns){
                ans.add('v' + str);
            } 
        }

        return ans;
    }

    //VOID TYPE 
    public static void getMazePaths(int sr, int sc, int dr, int dc, StringBuilder sb) {
        if(sr == dr && sc == dc){
            System.out.println(sb.toString());
            return;
        }

        //after this is pretty simple
        if(sr < dr){
           sb.append('h');
           getMazePaths(sr + 1, sc, dr, dc, sb);
           sb.deleteCharAt(sb.length() - 1);
        }

        if(sc < dc){
           sb.append('v');
           getMazePaths(sr, sc + 1, dr, dc, sb);
           sb.deleteCharAt(sb.length() - 1);
        }
    }

    
}
