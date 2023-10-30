import java.lang.reflect.Array;
import java.util.*;

public class leetcode16 {
    public static void main(String[] args) {

    }

    public static class Pair {
        int a;
        int b;

        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public static int[] sortByBits(int[] arr) {
        List<Integer> store = new ArrayList<>();
        Collections.sort(store,new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                int aBits = findSetBits(a);
                int bBits = findSetBits(b);
                return aBits - bBits == 0 ? a - b : aBits - bBits;
            }
        });
        return store.stream().mapToInt(i -> i).toArray();
    }

    public static int findSetBits(int curr){
        int cnt = 0;
        while(curr != 0){
            if((curr & 1) == 1) cnt++;
            curr = curr >> 1;
        }
        return cnt;
    }
}

