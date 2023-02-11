import java.awt.List;
import java.util.ArrayList;

public class majorityElement {
    public static void main(String[] args) {
        
    }

    //method -1 Hashmap - Freq
    //method -2 Sorting - nums[n/2]
    //method -3 using freq and number variable (check at each step shit) 
    //weird logic try to remember it bruh
    
    //Let's think about this bad boi for a second, hehehe
    //just remember this question solve for sure now

    //BRILLIANT SOLVE LITERALLY BRILLIANT FOR SURE MAN (i love this)
    public int majorityElement(int[] nums) {
        int freq = 0;
        long val = Long.MIN_VALUE;

        for(int ele : nums){
            if(ele == val){
                freq++;
            }else if(freq == 0){
                freq = 1;
                val = ele;
            }else{
                freq--;
            }
        }

        return (int)val;
    }

    //majority element 2
    //SIMILARLY DO FOR N/K times and shit, the logic will remain same bois
    //Just KEEP Increasing this shit
    public List<Integer> majorityElement(int[] nums) {
        int f1 = 0;
        int val1 = Integer.MIN_VALUE;
        int f2 = 0;
        int val2 = Integer.MIN_VALUE;
        for(int ele : nums){
            if(ele == val1){
                f1++;
            }else if(ele == val2){
                f2++;
            }else if(f1 == 0){
                val1 = ele;
                f1 = 1;
            }else if(f2 == 0){
                val2 = ele;
                f2 = 1;
            }else{
                f1--;
                f2--;
            }
        }

        //TO CHECK IF THE IGVEN TWO VALUES ARE RIGHT OR NOT
        int v1f = 0;
        int v2f = 0;
        for(int ele : nums){
            if(ele == val1){
                v1f++;
            }
            if(ele == val2){
                v2f++;
            }
        }

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(v1f > n/3){
            ans.add(val1);
        }

        if(v2f > n/3){
            ans.add(val2);
        }

        return ans;
    }

    //FOR GENERAL CASES (remember this code for sure)
    //SIMPLE STEPS
    //check if equal to part
    //check if any freq == 0
    //reduce all freq bois
}


