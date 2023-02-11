import java.util.Arrays;

public class allIndicesArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,4,8,4};
        int[] ans = allIndices(arr, 4, 0, 0);

        System.out.println(Arrays.toString(ans));
    }

    //le'ts solve this question
    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {

        //proper recursion logic hai isme, dope shit for sure 
        if(idx >= arr.length){
            return new int[fsf];
        }

        //pre part before calling the function
        if(arr[idx] == x){
            fsf++;
        }

        //now what!! 
        int[] given = allIndices(arr, x, idx + 1, fsf);

        //after calling the function
        if(arr[idx] == x){
            given[fsf-1] = idx;
        }

        return given;
    }
}
