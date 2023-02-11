import java.util.*;
import java.io.*;

class maxScore {

    //simple bois
    public static void main(String[] args){
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

        var ans = maxScoreWords(words, letters, score);
        System.out.println(ans);
 
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for(char ch : letters){  //you can never be ahead than me bois
            freq[ch - 'a']++;
        }    

        int ans = helper(words, freq, score, 0);
        return ans;
    }

    //let's do return type on this one bruh
    public static int helper(String[] words, int[] freq, int[] score, int idx){

        if(idx == words.length){
            return 0;
        }
            
        //don't take and move on
        int fans = helper(words, freq, score, idx + 1);


        //first check is possible or not
        boolean pos = true;
        char[] cword = words[idx].toCharArray();
        int sans = 0;
        
        int i;
        for(i = 0; i < cword.length; i++){
            char ch = cword[i];
            int posi = ch - 'a';
            if(freq[posi] == 0){
                pos = false;
                break;
            }

            freq[posi]--;
            sans += score[posi];
        }

        int taken = 0;
        if(pos){
            taken = helper(words, freq, score, idx + 1) + sans;
        }

        i--;
        while(i >= 0){
            freq[cword[i] - 'a']++;    
            i--;
        }
    
        return Math.max(fans, taken);
        
    }

}