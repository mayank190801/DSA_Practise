import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class maxChunks {

    //THIS MUCH CODE WORKED OUT BEAUTIFULLY
    //MY CODE IS BEAUTIFUL THAN EVER BOIS
    //FIRST PART
    public int maxChunksToSorted1(int[] arr) {
        int count = 0;
        int n = arr.length;

        int posReq = arr[0];
        for(int i = 0; i < n; i++){
            posReq = Math.max(arr[i], posReq);
            if(posReq == i){
                count++;
                if(i == n-1) return count;
                posReq = arr[i+1];
            }
        }
        return -1;
    }

    //THIS IS MAX CHUNKS TO SORTED 2
    //LOL SOMEHOW THIS CODE WORKS FOR GOD SAKe
    public int maxChunksToSorted(int[] arr){
        int[] copy = new int[arr.length];
        for(int i =0; i < arr.length; i++){
            copy[i] = arr[i];
        }

        Arrays.sort(copy);
        //now put in hashmap for now
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        int index = 0;
        for(int i : copy){
            map.putIfAbsent(i, new ArrayList<>());
            map.get(i).add(index);
            index++;
        }

        for(int i : map.keySet()){
            Collections.sort(map.get(i), Collections.reverseOrder());
        }

        //now replace in the primary arr for now
        for(int i = 0; i < arr.length ; i++){
            int curr = arr[i];
            ArrayList<Integer> req = map.get(curr);
            int newVal = req.get(req.size()-1);
            req.remove(req.size()-1);
            arr[i] = newVal;
        }

        int answer = maxChunksToSorted1(arr);
        return answer;
    }



    
}
