import java.util.Arrays;

public class buildingBridges {

    //this fuckin code works too lol
    //imma happy man!! this makes me happy for sure!! (makes me wanna cry for real dude)
    public static void main(String[] args) {
        int[] north = {8 ,1 ,4 ,3 ,5 ,2 ,6 ,7};    
        int[] south = {1 ,2 ,3 ,4 ,5 ,6 ,7 ,8};
        int n = north.length;

        int[][] arr = new int[n][2];
        for(int i= 0; i < n; i++){
            arr[i][0] = north[i];
            arr[i][1] = south[i];
        }

        //now put in the function and see if it runs or not(pretty imp thing to do)
        int ans = buildBridges(arr);
        System.out.println(ans);

    }

    public static int buildBridges(int[][] arr){

        //this piece of code below is beautiful as fuck man
        //just please for god sake remember this below code boi
        Arrays.sort(arr, (a,b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0]; //increasing order method
            } else{
                return a[1] - b[1]; //increasing order method
            }
        });

        //now i gotta find the lis for above shit!!!! in O(logn right)
        int ans = 1;
        for(int i = 1; i < arr.length; i++){
            int cidx = binarySearch(arr, 0, ans-1, arr[i][0]);
            if(cidx == ans){
                ans++;
            }
            arr[cidx][0] = arr[i][0]; //always gonna happen bois
        }
        return ans;
    }
    
    public static int binarySearch(int[][] nums, int si, int ei ,int val){
        while(si <= ei){
            int mid = (si + ei)/2;
            if(nums[mid][0] == val){
                return mid;
            }else if(nums[mid][0] < val){
                si = mid + 1;
            }else{
                ei = mid - 1;
            }
        }

        return si;  //simple as that bruh
    }
}
