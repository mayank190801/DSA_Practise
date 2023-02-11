import java.util.HashMap;

public class substringWithEqual012 {

    //count 0 1 2
    //this one is solved, loved this method for sure
    //something entirely new i have learned today
    long getSubstringWithEqual012(String str) 
    { 
        //convert this string to str
        char[] arr = str.toCharArray();

        HashMap<String, Long> map = new HashMap<>();
        map.put("0#0", 1L);
        long ans = 0;
        long z = 0;
        long o = 0;
        long t = 0;

        for(int i= 0; i < arr.length; i++){
            if(arr[i]== '0'){
                z++;
            }else if(arr[i] == '1'){
                o++;
            }else{
                t++;
            }
            String curr = (z-o) + "#" + (o-t);
            ans += map.getOrDefault(curr, 0L);
            map.put(curr, map.getOrDefault(curr, 0L) + 1L);
        }

        return ans;
    }

}
