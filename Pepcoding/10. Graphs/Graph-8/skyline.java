import java.util.*;

public class skyline {
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        getSkyline(buildings);
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> corners = new ArrayList<>();
        for(int i = 0; i < buildings.length; i++){
            int st = buildings[i][0];
            int en = buildings[i][1];
            int ht = buildings[i][2];

            corners.add(Arrays.asList(st, -ht));
            corners.add(Arrays.asList(en, ht));
        }

        //sorting using lambda baby, lambda is the best thing ever in this tech for sure
        Collections.sort(corners, (a,b) -> {
            if(a.get(0).equals(b.get(0))){
                return a.get(1) - b.get(1);
            }
            return a.get(0) - b.get(0);
        });

        int cht = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> corner : corners){
            int pt = corner.get(0);
            int ht = corner.get(1);

            //storing current active boxes
            if(ht < 0){
                pq.add(-ht);
            }else{
                pq.remove(ht);
            }

            if(pq.peek() != cht){
                ArrayList<Integer> base = new ArrayList<>();
                base.add(pt);
                base.add(pq.peek());
                ans.add(base);
                cht = pq.peek();
            }
        }

        return ans;
    }
}
