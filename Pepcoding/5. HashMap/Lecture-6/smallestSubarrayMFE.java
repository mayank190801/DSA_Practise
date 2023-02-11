import java.util.*;

public class smallestSubarrayMFE {

    //one traversal bitch bois
    //pretty much just what i thought bois
    //hheheheheh, just a bit different impelemnation
    //if one value and store 2 values????? You self made object bois
    //TRY THINKING IN OBJECT ORIENTED METHOD AT TIME BOIS

    //method 1 normal traversal which wouldn't work for sure
    //method 2 , we will do it below bois
    //I really really love his way of coding for sure, mind would have been kaafi annoying
    //STORING VALUES OF NO VALUE AND SHIT
    //Just best way too code below question for sure man

    //ALL OCCURRENCES OF MOST FREQUENT ELEMENTS
    ArrayList<Integer> smallestSubsegment(int arr[], int n)
    {
        //when all three freq, start and end are int,
        //dumbass simply use int[] array no?
        int[] ans = new int[3];
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i= 0; i < arr.length; i++){
            int[] last = map.get(arr[i]);
            if(last == null){
                last = new int[]{i,i,1};//start, end, freq;
                map.put(arr[i],last);//updation
            }else{
                last[2]++;
                last[1] = i;
            }
            
            //answer update for sure bois
            //dope updation toooooo
            if(ans[2] < last[2]){
                ans = last;
            }else if(ans[2] == last[2] && (last[1] - last[0]) < (ans[1] - ans[0])){
                ans = last;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i= ans[0] ; i <= ans[1]; i++){
            res.add(arr[i]);
        }

        return res;
    }

}
