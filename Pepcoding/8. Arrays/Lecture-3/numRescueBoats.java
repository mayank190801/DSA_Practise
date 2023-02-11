import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class numRescueBoats {

    //METHOD - Sort and put two pointers for this question 
    //Check for each case and simply add the first ele acc. to conditions

    //THIS CODE SIMPLY WORKS (much better piece of code for sure)
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length-1;

        int count = 0;
        while(l <= r){  //when l== r both cases would be handled for sure
            if(people[r] + people[l] <= limit){
                l++;
            }   
            r--;
            count++;
        }

        return count;
    }
    
}
