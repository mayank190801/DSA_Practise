import java.util.*;

public class insertIntervals {
    public static void main(String[] args) {
       
    }

    //FIRST METHOD
    //simple add the given interval in the array
    //and apply merge interval on it
    public int[][] merge(int[][] arr) {
        ArrayList<int[]> stack = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
        stack.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int[] lint = stack.get(stack.size() - 1);
            int[] mint = arr[i];
            if (mint[0] <= lint[1]) {
                stack.remove(stack.size() - 1);
                int[] temp = new int[2];
                temp[0] = lint[0];
                temp[1] = Math.max(lint[1], mint[1]);
                stack.add(temp);
            } else {
                stack.add(mint);
            }
        }
        int[][] ans = new int[stack.size()][2];
        for (int i = 0; i < stack.size(); i++) {
            ans[i] = stack.get(i);
        }
        return ans;
    }

    // INSERT INTERVALS

    public int[][] insert(int[][] arr, int[] nint) {
        int[][] arrcopy = new int[arr.length + 1][2];
        for (int i = 0; i < arr.length; i++) {
            arrcopy[i] = arr[i];
        }
        arrcopy[arr.length] = nint;
        return merge(arrcopy);
    }




    //SECOND METHOD
    //O(n), direct insert stuff bro
    public int[][] insert(int[][] arr, int[] nint) {
        //solve on your own bruh
        ArrayList<int[]> ans = new ArrayList<>();
        
        int n = arr.length;
        int i = 0;

        //first add very first elements bruh
        for(i= 0; i < n; i++){
            if(arr[i][0] <= nint[0])
                ans.add(arr[i]);
            else   
                break;
        }

        //now add nint
        //improv in if else code bois, for sure, this is very important 
        if(ans.size() == 0 || ans.get(ans.size()-1)[1] < nint[0]){
            ans.add(nint);
        }else{
            int[] prev = ans.get(ans.size()-1);
            if(nint[1] > prev[1]) prev[1] = nint[1];
        }
       
        //now add the leftover ones
        for(; i < n; i++){
            int[] prev = ans.get(ans.size()-1);
            int[] curr = arr[i];

            //now we have both prev and curr
            if(curr[0] > prev[1]){
                ans.add(curr);
            }else{
                if(curr[1] > prev[1]){
                    prev[1] = curr[1];
                }
            }
        }

        i = 0;
        int[][] answer = new int[ans.size()][2];
        for(i= 0; i < ans.size(); i++){
            answer[i][0] = ans.get(i)[0];
            answer[i][1] = ans.get(i)[1];
        }

        return answer;

    }

    
}
