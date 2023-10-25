
public class leetcode5 {
    public static void main(String[] args) {

    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        Pair max = new Pair(-1, -1);
        Pair min = new Pair(Integer.MAX_VALUE, -1);

        //let's solve it asap brother,
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int len = nums.length;
        for(int i = 0; i < len - indexDifference; i++){
            int curr = nums[i];
            if(curr > max.a){
               max.a = curr;
               max.b = i;
            }
            if(curr < min.a){
                min.a = curr;
                min.b = i;
            }

            //so now we have some shit as updated,
            //get ahaed of that index
            int value = nums[i + indexDifference];
            if(Math.abs((value - max.a)) >= valueDifference){
               ans[0] = max.b;
               ans[1] = i + indexDifference;
            }
            if(Math.abs((value - min.a))>= valueDifference){
               ans[0] = min.b;
               ans[1] = i + indexDifference;
            }

        }


        return ans;
    }

    static class Pair{
        int a;
        int b;

        Pair(int a, int b){
            this.a =a;
            this.b = b;
        }
    }
}
