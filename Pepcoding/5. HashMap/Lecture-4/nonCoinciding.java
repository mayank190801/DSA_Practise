import java.util.HashMap;

public class nonCoinciding {
    public static void main(String[] args) {
        //EASE QUESTION FOR SURE
    }

    //main
    //code kara do lekin, kara do boss
    static int numOfPairs(int[] X, int[] Y, int N) {
        //THIS FREAKIN CODE WORKS BOIS
        //CONGRATULATIONS

        int ans = 0;
        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();
        HashMap<String, Integer> xy = new HashMap<>();

        for(int i = 0; i < N ; i++){
            int xc = x.getOrDefault(X[i], 0);
            int yc = y.getOrDefault(Y[i], 0);
            int xyc = xy.getOrDefault(X[i] + "#" + Y[i], 0);

            //Only this was the important thing to do here
            ans += (xc + yc - 2*xyc);

            x.put(X[i], x.getOrDefault(X[i], 0) + 1);   
            y.put(Y[i], y.getOrDefault(Y[i], 0) + 1);
            xy.put(X[i] + "#" + Y[i], xy.getOrDefault(X[i] + "#" + Y[i], 0) + 1);
        }

        return ans;
    }

}
