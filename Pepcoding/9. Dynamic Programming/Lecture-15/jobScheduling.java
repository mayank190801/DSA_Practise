import java.util.*;

public class jobScheduling {
    public static void main(String[] args) {
        int[] startTime = {1,2,3,4,6};
        int[] endTime = {3,5,10,6,9};
        int[] profit = {20,20,100,70,60};
        
        int ans = jobScheduling(startTime, endTime, profit);
        System.out.println(ans);
    }
    
    //Time - O(nlogn)
    //Space - O(n)

    //SIR CODE
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {  
        int len = startTime.length;
        int[][] arr = new int[len][3];

        for(int i= 0; i < len; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        //Sort on start bois
        Arrays.sort(arr, (a,b) -> (a[0] - b[0]));
        int[] dp = new int[len];

        dp[len - 1] = arr[len - 1][2];  //profit of last meet
        for(int i = len - 2; i >= 0; i--){
            dp[i] = dp[i + 1]; //if exclude
            int idx = binarySearchValidStart(arr, i + 1, len - 1, arr[i][1]);

            int include = idx == len ? arr[i][2] : arr[i][2] + dp[idx];
            dp[i] = Math.max(dp[i], include);  //simply include this bad boi
        }

        return dp[0];
    }

    public static int binarySearchValidStart(int[][] arr, int si, int ei, int data){
        while(si <= ei){
            int mid = (si + ei)/2;
            if(arr[mid][0] < data){
                si = mid + 1;
            }else{
                ei = mid - 1;
            }
        }
        return si;
    }

    //MY CODE FOR THIS FUCKALL (overdid a lot of code you idiot)
    //You didn't have to use TREEMAP at all in this question
    //you fucking idiot!!!! 

    //these contraints are given for us!
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {  

        //I actually think this question is solvable for sure!! (pretty pretty solvable) 
        //Could be different ways of solving this, you do what you think is best!!! (simple)
        TreeMap<Integer, ArrayList<Pair>> map = new TreeMap<>(Collections.reverseOrder());
        int n = startTime.length;
        for(int i= 0; i < n; i++){
            int st = startTime[i];
            int et = endTime[i];
            int pr = profit[i];

            map.putIfAbsent(st, new ArrayList<>());
            map.get(st).add(new Pair(et, pr));  //simple
        }     

        //simple as that for sure!! (i really really like it boi!!) 
        int[][] dp = new int[map.size()][2];
        int len = dp.length;
         
        int curr = len - 1;
        for(int st : map.keySet()){
            int right = curr < len - 1 ? dp[curr + 1][1] : 0;
            dp[curr][1] = right;

            ArrayList<Pair> list = map.get(st);
            // System.out.println(st);
            // System.out.println(list);

            //if taking this one
            for(Pair p : list){
                int sum = p.b;

                //now find the maximum after that
                int search = p.a; //iski starting se 

                int end = -1;
                int l = curr + 1;
                int r = len - 1;

                while( l <= r){
                    int middle = (l + r)/2;
                    if(dp[middle][0] >= search){
                        end = middle;
                        r = middle - 1;
                    }else{
                        l = middle + 1;
                    }
                }

                if(end != -1){
                    sum += dp[end][1];
                }

                dp[curr][1] = Math.max(dp[curr][1], sum);
            }

            dp[curr][0] = st;
            curr--;
        }

        return dp[0][1];
    }

    public static class Pair{

        public int a;
        public int b;

        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString(){
            return a + " -> "  + b;
        }
    }
}
