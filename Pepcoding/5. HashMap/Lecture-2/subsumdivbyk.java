//import this bitch everytime
import java.util.*;

public class subsumdivbyk {
    public static void main(String[] args) {
        
    }
    
    //there are some edges cases in this part of the question bruh, always remember that
    //take in consideration some edge cases for this one big boy

    //-a%b ==== (k*b + a)%b === (a%b + k) this is important 
    //ye toh clear hua ni bc
    //baaki question kaafi similar similar hai vaise toh, try to do them on your own
    //then look at the solution
    //we are handling shit only
    public long subCount(long arr[] ,int n,int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int sum = 0;
        int count = 0;

        for(int i = 0; i < n; i++){
            sum += arr[i];
            int r = (sum%k);
            
            //could be a better way to do this for sure
            //figure it out my man
            //This could be done in O(n) probably maybe sometime
            if(r < 0){
                r += k;
            }

            count += map.getOrDefault((r), 0);
            //now put it in the array for sure
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
         
        return count;
    }
}
