import java.util.Arrays;

public class shouldRun {
    public static void main(String[] args) {
        System.out.println("hey does this work?");
        int n = 4;
        int height[] = {4,1,4,10};
        int width[] = {6,2,5,12};
        int length[] = {7,3,6,32};

        int solve = maxHeight(height, width, length, n);
        System.out.println(solve);
    }



    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        int[][] box = new int[n][3];
        for(int i = 0; i < n; i++){
            box[i][0] = height[i];
            box[i][1] = width[i];
            box[i][2] = length[i];
        }

        int[][] arr = new int[6*n][3];
        for(int i= 0; i < n; i++){
            for(int j = 0; j <= 2; j++){
                arr[6*i  + 2*j][0] = box[i][j];
                arr[6*i  + 2*j][1] = box[i][(j + 1) % 3];
                arr[6*i  + 2*j][2] = box[i][(j + 2) % 3];

                arr[6*i  + 2*j + 1][0] = box[i][j];
                arr[6*i  + 2*j + 1][1] = box[i][(j + 2) % 3];
                arr[6*i  + 2*j + 1][2] = box[i][(j + 1) % 3];
            }
        }

        Arrays.sort(arr, (a,b) -> a[1] - b[1] != 0 ? a[1] - b[1] : b[2] - a[2]);

        //now applying for loop ka system on this question for now!! (remember how we do that!! Very difficult)
        int[] maxHeight = new int[arr.length];
        maxHeight[0] = arr[0][0];
        int ans = maxHeight[0];

        for(int i = 1; i < arr.length; i++){
            maxHeight[i] = arr[i][0];
            for(int j = i -1; j >= 0; j--){
                if(arr[i][2] > arr[j][2]){
                    maxHeight[i] = Math.max(maxHeight[i], maxHeight[j] + arr[i][0]);
                }
            }
            ans = Math.max(maxHeight[i], ans);
        }

        //perfect run for sure!
        return ans;
    }


}
