import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kthclosest {

    //let's solve this bad boi
    //A LOT OF LOGICAL IMPROVEMENTS IN MY PIECE OF CODE FOR SURE
    //DO LEARN FROM IT AND LEARN THIS BAD BOI METHOD TOO
    //TO FIND THE PERFECT LOCATION
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //let's code it down 
        int si = 0;
        int ei = arr.length-1;

        List<Integer> list = new ArrayList<>();
        int index = -1;

        //BINARY SEARCH BOIS (works totally fine for sure)
        //Keep upsolving and keep improving for sure
        while(si <= ei){
            int mid = (si + ei)/2;
            if(arr[mid] <= x){
                index = mid;
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }

        //Setting the correct values for surety bro
        // index = index == -1 ? 0 : index;
        int l = index;
        int r = index+1;
        // if(arr[index] == x){
        //     list.add(x);
        //     l--;
        //     k--;
        // }
        // System.out.println(l + " " + r);

        //TO SIMPLY ADD NUMBERS ON LEFT AND RIGHT
        //HOW TO DO IT MORE EFFICIENTLY????
        while(k > 0){
            int lval = l== -1? Integer.MAX_VALUE : Math.abs(x-arr[l]);
            int rval = r == arr.length ? Integer.MAX_VALUE: Math.abs(x-arr[r]);
            if(lval <= rval){
                list.add(arr[l]);
                l--;
            }else{
                list.add(arr[r]);
                r++;
            }
            k--;
        }


        Collections.sort(list);
        return list;
    }


    //SIR CODE VERSION
    //CHECK THIS OUT, HARD TO BE ACCURATE FOR SURE
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pl = perfectLocation(arr, x);
        int l = pl-1;
        int r = pl;

        List<Integer> ans = new ArrayList<>();
        while(k > 0){
            int lval = l== -1? Integer.MAX_VALUE : Math.abs(x-arr[l]);
            int rval = r == arr.length ? Integer.MAX_VALUE: Math.abs(x-arr[r]);
            if(lval <= rval){
                list.add(arr[l]);
                l--;
            }else{
                list.add(arr[r]);
                r++;
            }
            k--;
        }

        Collections.sort(list);
        return ans;
    }

    public int perfectLocation(int[] nums, int tar){
        int si = 0;
        int ei = nums.length-1;
        while(si <= ei){
            int mid = (si + ei)/2;
            if(nums[mid] == tar){
                return mid;
            }else if(nums[mid] < tar){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        return si;
    }
    
}
