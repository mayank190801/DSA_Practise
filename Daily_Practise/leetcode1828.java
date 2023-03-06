public class leetcode1828 {
    //this should simply work bruh!
    public static void main(String[] args) {


    }

    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            for(int j = 0; j < points.length; j++){
                if(queries[i][2] * queries[i][2] >= ((points[j][0]-queries[i][0])*(points[j][0]-queries[i][0]) + (points[j][1]-queries[i][1])*(points[j][1]-queries[i][1]))) ans[i]++;
            }
        }
        return ans;
    }
}
