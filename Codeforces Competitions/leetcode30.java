public class leetcode30 {
    public static void main(String[] args) {

    }

    public static int distributeCandies(int n, int limit) {
        int ans = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                for(int k = 0; k <= n; k++){
                    if(i + j + k == n){
                        if(i <= limit && j <= limit && k <= limit) ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static long distributeCandies(int n, int limit) {
        int ans = 0;
        for(int i = 0; i <= n; i++){
            int rem = n - i;
            if(limit >= rem) ans+= rem+1;
            else{
                int lower = rem - limit;
                ans += lower + 1;
            }
        }
        return ans;
    }

    public static long maxSpending(int[][] values) {
        long ans = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = values.length;
        int m = values[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                list.add(values[i][j]);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        long days = n*m;
        for(int i=  0; i < days; i++){
           ans += days * list.get(i);
           days--;
        }
        return ans;
    }

    //we should upsolve the question, I feel it would teach me a lot in order to how to tackle this shitty problems
    //that would be really really helpful for sure, to be able to tackle these shitty problems any time any day I want to



}
