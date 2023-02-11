import java.util.*;
import java.io.*;
import java.awt.Point;


public class lettertile{

    public static String sortString(String given){
        int[] arr = new int[26];
        for(char ch : given.toCharArray()){
            arr[ch-'A']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            for(int j= 0; j < arr[i] ; j++){
                sb.append((char)('A'+i));
            }
        }

        String answer = sb.toString();
        return answer;

    }
    public static void main(String[] args){
        String fuck = "CDC";
        //i gotta sto
        String tiles = sortString(fuck);

        char[] inp  = tiles.toCharArray();

        ArrayList<String> list = new ArrayList<>();
        solve(inp, 0, "", '9', true, list);
        System.out.println(list);
        
        int output = 0;
        for(int i= 0; i < list.size(); i++){
            char[] temp = list.get(i).toCharArray();
            output += permDuplicay(temp, 0);
        }
        System.out.println(output);
    }

    public static int permDuplicay(char[] inp, int idx){
        if(idx == inp.length){
            return 1;
        }

        Set<Character> set = new HashSet<>();
        //you can use either set or int array, whatever you want
        int res = 0;
        for(int i= idx; i < inp.length; i++){
            if(set.contains(inp[i])) continue;
            set.add(inp[i]);

            char temp = inp[idx];
            inp[idx] = inp[i];
            inp[i] = temp;
            res += permDuplicay(inp, idx+1);
            temp = inp[idx];
            inp[idx] = inp[i];
            inp[i] = temp;
        }

        return res;
    }

    //first figure out the subsequences and then figure out the other part
    //not hard, just learn bruh, this wouldn't work otherwise
    
    public static void solve(char[] inp, int idx , String answer, char last, boolean taken, ArrayList<String> list){

        //but for now remove the repetition baby
        //simple as that
        if(idx == inp.length){
            if(answer.length() == 0) return;
            list.add(answer);
            return;
        }

        if(last == inp[idx] && !taken){
            solve(inp, idx+1, answer, inp[idx], false, list);
        }else{
            solve(inp, idx+1, answer+inp[idx], inp[idx], true, list);
            solve(inp, idx+1, answer, inp[idx], false, list);
        }

    }

}
