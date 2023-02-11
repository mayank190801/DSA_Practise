import java.util.HashMap;

public class morningAssembly{
    public static void main(String[] args) {
        
    }

    //simple question, but i am an idiot for sure man!
    static int sortingCost(int N, int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int lcs = 0;

        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele-1, 0)+1);
            lcs = Math.max(lcs, map.get(ele));
        }

        return N-lcs;
    }
    

}