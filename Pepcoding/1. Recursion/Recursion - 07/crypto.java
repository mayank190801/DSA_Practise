import java.util.Arrays;

public class crypto{


    public static void main(String[] args) {
        //let's solve from here
        String s1 = "send";
        String s2 = "more";
        String s3 = "money";

        cryptoHelper(s1,s2,s3);
        

    }

    public static void cryptoHelper(String s1, String s2, String s3){
        StringBuilder sb = new StringBuilder();
        int[] alpha = new int[26];

        String[] s = {s1,s2,s3};
        for(String sh: s){
            for(char ch : sh.toCharArray()){
                if(alpha[ch-'a'] == 1) continue;
                alpha[ch-'a'] = 1;
                sb.append(ch);
            }
        } 

        String unique = sb.toString();
        System.out.println(unique);

        alpha = new int[26];
        int[] arr = new int[10];

        helper(unique, 0, s, arr, alpha);


    }

    public static int generateSums(String str,int[] alpha){
        int count = 0;
        for(int i= 0; i < str.length(); i++){
            count = count * 10 + (alpha[str.charAt(i)-'a']);
        }
        return count;
    }

    public static boolean helper(String unique, int index, String[] s, int[] arr, int[] alpha){

        if(index == unique.length()){
            int s1 = generateSums(s[0], alpha);
            int s2 = generateSums(s[1], alpha);
            int s3 = generateSums(s[2], alpha);

            if(s1 + s2 == s3){
                System.out.println(s1 + " " + s2 + " " + s3);
                return true;
            }
            
            return false;
        }

        char curr = unique.charAt(index);
        boolean res = false;
        for(int i= 0 ; i <= 9; i++){
            if(arr[i] == 1) continue;
            arr[i] = 1;
            alpha[curr-'a'] = i;
            res = res || helper(unique, index+1, s, arr , alpha);
            alpha[curr-'a'] = -1;
            arr[i] = 0;
        }

        return res;
    }

}