import java.util.List;

public class leetcode15 {
    public static void main(String[] args) {

    }


    //
    public static int minimumOperations(List<Integer> nums) {
        //let's figure this out, like no matter what figuer this out
        //count of 3 in all should be there, right??
        int total3 = 0;
        for(int i : nums){
            if(i == 3) total3++;
        }

        //more like a 2 pointer question for sure
        //now we gotta figuer out the minimum answer
        //how the fuck I am solving one question after another, when I totally have no idea what I am doing
        //seriously wtf
        int ans = Integer.MAX_VALUE;
        int len = nums.size();
        int one = 0;
        int three = 0;
        for(int i = -1; i < len; i++){
            if(i != -1) {
                if(nums.get(i) == 1) one++;
                if(nums.get(i) == 3) three++;
            }
            int two = 0;
            int tempThree = three;
           for(int j = i; j < len; j++){
              if(i != j) {
                  if(nums.get(j) == 2) two++;
                  if(nums.get(j) == 3) tempThree++;
              }
              int expense = (i + 1 - one) + (j - i - two) + (len - 1 - j - (total3 - tempThree));
              ans = Math.min(ans, expense);
           }
        }

        return ans;
    }
}
