import java.util.Arrays;

public class cryptoUpdate{

    //["SEIS","CATORCE","SETENTA"]
    //"NOVENTA"
    public static void main(String[] args) {
        //let's solve from here
        // ["AB","CD","EF"]
        // "GHIJ"
        String[] words = {"AB","CD","EF"};
        String result = "GHIJ";

        boolean answer = cryptoHelper(words, result);
        System.out.println(answer);
    }

    public static boolean cryptoHelper(String[] words, String result){
        StringBuilder sb = new StringBuilder();
        int[] alpha = new int[26];

        //String s and words are needed
        //i have to write this question for acceptance format, nothing else
        String[] s = new String[words.length + 1];
        for(int i = 0; i < words.length; i++){
            s[i] = words[i];
        }
        s[words.length]=result;
 
        for(String sh: s){
            for(char ch : sh.toCharArray()){
                if(alpha[ch-'A'] == 1) continue;
                alpha[ch-'A'] = 1;
                sb.append(ch);
            }
        } 

        String unique = sb.toString();
        System.out.println(unique);

        alpha = new int[26];
        int[] arr = new int[10];

        int[] possible = new int[26];
        Arrays.fill(possible, 1);
        
        //go through all words and do that shit once and for all
        for(int i= 0; i < s.length ; i++){
            if((alpha[s[i].charAt(0)-'A'] == 0 && s[i].length() != 0)) {
                possible[s[i].charAt(0)-'A'] = 0;
            }
        }

        System.out.println(Arrays.toString(possible));

        boolean ans = helper(unique, 0, s, arr, alpha, possible);
        return ans;
        
    }

    public static int generateSums(String str,int[] alpha){
        int count = 0;

        for(int i= 0; i < str.length(); i++){
            count = count * 10 + (alpha[str.charAt(i)-'A']);
        }
         
        return count;
    }

    public static boolean helper(String unique, int index, String[] s, int[] arr, int[] alpha, int[] possible){

        if(index == unique.length()){

            int[] temp = new int[s.length];
            int totalSum = 0;
            for(int i = 0; i < s.length; i++){
                temp[i] = generateSums(s[i], alpha);
                totalSum += temp[i];
            }

            int leftSum = totalSum-temp[s.length-1];
            int rightSum = temp[s.length-1];
            
            if(leftSum == rightSum){
                // System.out.println(Arrays.toString(alpha));
                return true;
            }
            
            return false;
        }

        char curr = unique.charAt(index);
        boolean res = false;
        for(int i= 0 ; i <= 9; i++){
            if(arr[i] == 1 || (i == 0 && possible[curr-'A'] == 0)) continue;
            arr[i] = 1; 
            alpha[curr-'A'] = i;
            res = res || helper(unique, index+1, s, arr , alpha, possible);
            if(res) return true;
            alpha[curr-'A'] = -1;
            arr[i] = 0;
        }

        return res;
    }

}