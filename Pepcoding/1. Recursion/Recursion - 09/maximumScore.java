public class maximumScore {
    public static void main(String[] args) {
        String[] words = {"dog","cat","dad","good"};
        String[] letterss = {"a","a","c","d","d","d","g","o","o"};
        char[] letters = new char[letterss.length];
        int[] freq = new int[26];


        int[] score= {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        
        for(int i= 0; i < letterss.length; i++){
            letters[i] = letterss[i].charAt(0);
        }

        //simple as that
        for(char ch : letters){
            freq[ch-'a']++;
        }

        int answer = solve(words, freq, score, 0);
        System.out.println(answer);
        //now all input is pretty much ready, let's move forward, and solve this problem for the better
        //let's do this man
    }

    public static int solve(String[] words, int[] freq, int[] score, int index){

        if(index == words.length){
           return 0;
        }

        int dont = solve(words, freq, score, index+1);

        int cscore = 0;
        String curr = words[index];
        boolean possible = true;

        int i;
        for( i = 0; i < curr.length(); i++){
            if(freq[curr.charAt(i)-'a'] == 0){
                possible = false;
                break;
            }

            freq[curr.charAt(i)-'a']--;
            cscore += score[curr.charAt(i)-'a'];
        }

        int taken = 0;
        if(possible){
            taken = solve(words, freq, score, index+1) + cscore;
        }

        i--;
        while(i >= 0){
            freq[curr.charAt(i) -'a']++;
            i--;
        }
        
        return Math.max(dont, taken);
    }
    
}
