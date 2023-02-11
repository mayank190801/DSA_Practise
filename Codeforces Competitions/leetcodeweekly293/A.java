import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        
    }

    public static List<String> removeAnagrams(String[] words) {
        //only 100 words in total for sure, simple as fuck bois
        //an arraylist could be used no?
        //or two pointers?
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            list.add(i);
        }

        //simply
        while(true){

            boolean flag = true;
            for(int i= 0; i < list.size() - 1; i++){
                int curr = list.get(i);
                int next = list.get(i + 1);

                String word1 = words[curr];
                String word2 = words[next];

                if(isAnagram(word1, word2)){
                    list.remove(i + 1);  //simple
                    flag = false;
                    break;
                }
            }

            if(list.size() <= 1) break;
            if(flag) break;
        }

        List<String> ans = new ArrayList<>();
        for(int i : list){
            ans.add(words[i]);
        }

        return ans;
    }

    public static boolean isAnagram(String word1, String word2){
        int[] f = new int[26];
        int[] s = new int[26];

        for(char ch : word1.toCharArray()){
            f[ch - 'a']++;
        }
        for(char ch : word2.toCharArray()){
            s[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(f[i] != s[i]) return false;
        }

        return true;
    }
}
