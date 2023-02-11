import java.lang.reflect.Array;
import java.util.ArrayList;

public class mazePathMultipleJumps {
    public static void main(String[] args) {
        //let's imagine this question, and try to solve it asap for sure!
        ArrayList<String> ans = getMazePaths(1, 1, 2, 2);
        System.out.println(ans);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column

    //RETURN TYPE
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {  

        // System.out.println(sr + " " + sc + " " + dr + " " + dc);

        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add(""); //add empty string to the game for the question
            return base;
        }
        
        //after this we have reached here so, hmm, simple, and annoyingly recursive for sure
        ArrayList<String> ans = new ArrayList<>();


        //for adding h1, h2, h3, put some checks and keep on doing it 
        int idx = 1;
        while(sc + idx - 1 < dc){
            ArrayList<String> recAns = getMazePaths(sr, sc + idx, dr, dc);
            for(String str : recAns){

                ans.add('h' + "" + idx + str);
            }
            idx++;
        }

        idx = 1;
        while(sr + idx - 1 < dr){
            ArrayList<String> recAns = getMazePaths(sr + idx, sc, dr, dc);
            for(String str : recAns){
                ans.add('v' + "" + idx + str);
            }
            idx++;
        }

        //now same for diagonal would be super amazing for sure
        idx = 1;
        while(sc + idx - 1< dc && sr + idx - 1 < dr){
            ArrayList<String> recAns = getMazePaths(sr + idx, sc + idx, dr, dc);  //uske aage ka return krlo
            for(String str : recAns){
                ans.add('d' + "" + idx + str);
            }
            idx++;
        }

        return ans;
    }
    
}
