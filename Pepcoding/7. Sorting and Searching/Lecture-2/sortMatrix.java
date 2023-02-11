import java.util.*;

public class sortMatrix {
    public static void main(String[] args) {
        
    }

    //ONE MORE METHOD IS TO REVERSE ARRAYLIST AND REMOVE FROM THE LAST
    //THAT IS SIMPLE AS FUCK TOO, whatever you like boi

    //simple stuff boi
    //use two methods, 
    //map
    //count sort bois
    //solved in 8ms baby
    //MY OWN WRITTEN CODE BOYS
    public int[][] diagonalSort(int[][] mat) {
    
        //return the same matrix for sure bois
        int n = mat.length;
        int m = mat[0].length;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i= 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!map.containsKey(i-j)){
                    map.put(i-j, new ArrayList<>());
                }
                map.get(i-j).add(mat[i][j]);
            }
        }

        //simple stuff , now let's move forward and solve this for sure
        //let's move forwardd
        for(int key : map.keySet()){
            Collections.sort(map.get(key));
        }

        //now we gotta only add it back in, that's the stuff i gotta do only
        //let's do that
        //with i = 0;
        //top to left
        for(int j= 0; j< m; j++){
            int x = 0;
            int y = j;
            int index = 0;
            while(x < n && y < m){
                mat[x][y] = map.get(x-y).get(index++);
                x++;
                y++;
            }
        }

        //top to bottom 
        for(int i= 1; i < n; i++){
            int x = i;
            int y = 0;
            int index = 0;
            while(x < n && y < m){
                mat[x][y] = map.get(x-y).get(index++);
                x++;
                y++;
            }
        }

        return mat;
    }


    //SECOND MY THINKING IMPLEMENTATION
    //This one is 13ms, but def less code and complexity for sure
    public int[][] diagonalSort(int[][] mat) {
    
        //return the same matrix for sure bois
        int n = mat.length;
        int m = mat[0].length;

        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        for(int i= 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!map.containsKey(i-j)){
                    map.put(i-j, new LinkedList<>());
                }
                map.get(i-j).add(mat[i][j]);
            }
        }

        //simple stuff , now let's move forward and solve this for sure
        //let's move forwardd
        for(int key : map.keySet()){
            Collections.sort(map.get(key));
        }

        for(int i= 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = map.get(i-j).getFirst();
                map.get(i-j).removeFirst();
            }
        }

        return mat;
    }


    //SORT DIAGONALS USING COUNT SORT
    //DAMN BOI, SUPER FAST WITH COUNT SORT 
    //O(n) rather than O(nlogn)
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int j= 0; j< m; j++){
            countSort(mat, 0, j);
        }

        for(int i= 1; i < n; i++){
            countSort(mat, i, 0);
        }

        return mat;
    }

    public void countSort(int[][] mat, int x , int y){
        int[] fmap = new int[101];
        int n= mat.length;
        int m = mat[0].length;

        int xx = x;
        int yy = y;

        while(x < n && y < m){
            fmap[mat[x][y]]++;
            x++;
            y++;
        }

        x = xx;
        y = yy;
        int pt = 0;
        while(x < n && y < m){
            if(fmap[pt] > 0){
                mat[x][y] = pt;
                fmap[pt]--;
                x++;
                y++;
            }else{
                pt++;
            }
        
        }
        
    }



}
