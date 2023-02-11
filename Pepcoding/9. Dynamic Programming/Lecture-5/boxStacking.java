import java.util.Arrays;

import javax.swing.Box;

public class boxStacking {

    //let's think about this boi!
    public static void main(String[] args) {
        int[] height = {1,2,3};
        int[] width = {4,5,6};
        int[] length = {7,8,9};

        maxHeight(height, width, length, height.length);
    }

    //BRUTE FORCE BOX STACKING
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        int len = height.length;
        int[][] arr = new int[6*len][3];

        //converting our input to something more edible
        int[][] box = new int[len][3];
        for(int i= 0; i < len; i++){
            box[i][0] = height[i];
            box[i][1] = width[i];
            box[i][0] = length[i]; 
        }

        //since the input are different do it accordingly
        //do it according to your own comfort for sure!! (don't take any pressure)
        //simple as that!! no pressure (no pressure)

        //first as height and then so on
        for(int i= 0; i < len; i++){
            for(int j = 0; j < 3; j++){
                //some maths in here boi
                arr[6*i + 2*j][j%3] = box[i][0];
                arr[6*i + 2*j][(j+1)%3] = box[i][1];
                arr[6*i + 2*j][(j+2)%3] = box[i][2];

                arr[6*i + 2*j + 1][j%3] = box[i][0];
                arr[6*i + 2*j + 1][(j+1)%3] = box[i][2];
                arr[6*i + 2*j + 1][(j+2)%3] = box[i][1];
            }
        }

        //sort
        //Sort on second (russian box ka concept used in here)
        Arrays.sort(arr, (a,b) ->{
            if(a[1] == b[1]){
                return b[2] - a[2];
            }else{
                return a[1] = b[1];
            }
        });

        //LIS on third and answer on first
        int ans = lisBoxStacking(arr);
        return ans;
    }
    
    //code for maxSum in increasing subsequence (everything is basically connected)
    //v.imp to figure that out in the questions man!!!!
    public static int lisBoxStacking(int[][] arr){
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = arr[0][0];
        int ans = arr[0][0];

        for(int i = 1; i < len; i++){
            dp[i]= arr[i][0];
            for(int j =i-1 ; j >= 0; j--){
                if(arr[1][2] > arr[j][2]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][0]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;

    }




    //OPTIMISED CODE FOR THIS BAD BOI
    //I AM FUCKED WITH ITS OPTIMISATION BRO (these questions are sick af)
    //i don't really like them a single percent for sure

    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        int len = height.length;
        int[][] arr = new int[3*len][3];

        //converting our input to something more edible
        int[][] box = new int[len][3];
        for(int i= 0; i < len; i++){
            box[i][0] = height[i];
            box[i][1] = width[i];
            box[i][0] = length[i]; 
        }

        //since the input are different do it accordingly
        //do it according to your own comfort for sure!! (don't take any pressure)
        //simple as that!! no pressure (no pressure)

        //first as height and then so on
        for(int i= 0; i < len; i++){
            for(int j = 0; j < 3; j++){
                //some maths in here boi
                arr[3*i + j][0] = box[i][j];
                arr[3*i + j][1] = Math.min(box[i][(j+1)%3],box[i][(j+2)%3]);
                arr[3*i + j][2] = Math.max(box[i][(j+1)%3],box[i][(j+2)%3]);
            }
        }

        //sort
        //Sort on second (russian box ka concept used in here)
        Arrays.sort(arr, (a,b) ->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }else{
                return a[0] = b[0];
            }
        });

        //LIS on third and answer on first
        int ans = lisBoxStacking(arr);
        return ans;
    }
    
    //code for maxSum in increasing subsequence (everything is basically connected)
    //v.imp to figure that out in the questions man!!!!
    public static int lisBoxStacking(int[][] arr){
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = arr[0][2];
        int ans = arr[0][2];

        for(int i = 1; i < len; i++){
            dp[i]= arr[i][2];
            for(int j =i-1 ; j >= 0; j--){
                if(arr[1][1] > arr[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][2]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;

    }
    

    //SO if we could take only one instance from all those 6 backs
    //we would set one parameter state and reverse sort everyone else according to that
    //that means we would take only one value from all those boi
    //make some logic, but dry run and stuff is very importatn to make it clear

}
