import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class permutation{

    public static void main(String[] args) {

        String given = "abc";

        /// ------------ different --------------
        permutation1Me(given.toCharArray(), 0);
        permutation1Sir(given, "");

        ArrayList<String> ans = permutation1MeReturn(given);
        System.out.println(ans);

        ArrayList<String> ans2 = permutation1SirReturn(given, 0);
        System.out.println(ans2);

        /// ------------ same --------------
        permutation2MeVoid("aabb".toCharArray(), 0);
        permutation2SirVoid("aabb", "");


    }

    public static void swap(char[] given, int left, int right){
        char temp = given[left];
        given[left] = given[right];
        given[right] = temp;
    }

    //------------------------------------------------------------------------
    //Different 
    //-- void -- 

    //my method
    public static void permutation1Me(char[] given, int index){
        if(index == given.length){
            System.out.println(Arrays.toString(given));
            return;
        }

        for(int i = index; i < given.length; i++){
            //first swap with yourself
            swap(given, index, i);
            permutation1Me(given, index + 1);
            swap(given, index, i);
        }
    }


    //sir method - string splitting , taking what we want, and sending rest ahead
    public static void permutation1Sir(String given, String ans){
        if(given.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i= 0; i < given.length(); i++){
            //cut the given string and send the rest ahead
            String ngiven = given.substring(0, i) + given.substring(i + 1, given.length());
            permutation1Sir(ngiven, ans + given.charAt(i));                        
        }
    }


    //return 

    //my method
    public static ArrayList<String> permutation1MeReturn(String given){

        if(given.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> answer = new ArrayList<>();
        //otherwise
        for(int i= 0; i < given.length(); i++){
            char remove = given.charAt(i);
            String temp = given.substring(0, i)  + given.substring(i + 1, given.length());
            
            ArrayList<String> curr = permutation1MeReturn(temp);
            //har string ke aage ek char krke return
            for(String s : curr){
                answer.add(remove + s);
            } 
        }
    
        return answer;
    }


    //sir method
    public static ArrayList<String> permutation1SirReturn(String given, int index){

        if(index == given.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> answer = new ArrayList<>();
        char curr = given.charAt(index);
        
        ArrayList<String> temp = permutation1SirReturn(given, index + 1);
        for(String s : temp){
            for(int i = 0; i <= s.length(); i++){  //fingers like intersection
                answer.add(s.substring(0, i) + curr + s.substring(i, s.length()));
            }
        }
    
        return answer;
    }


    //------------------------------------------------------------------------

    //Same ( -- some same characters might be present -- )

    //Void 
    public static void permutation2MeVoid(char[] given, int index){
        if(index == given.length){
            System.out.println(Arrays.toString(given));
            return;
        }

        int[] alpha = new int[26];
        for(int i = index; i < given.length; i++){
            if(alpha[given[i] - 'a'] == 1) continue;
            alpha[given[i] - 'a'] = 1;
            
            swap(given, index, i);
            permutation2MeVoid(given, index + 1);
            swap(given, index, i);
        }
    }


    // sir method - string splitting , taking what we want, and sending rest ahead
    public static void permutation2SirVoid(String given, String ans){
        if(given.length() == 0){
            System.out.println(ans);
            return;
        }

        int[] alpha = new int[26];
        for(int i= 0; i < given.length(); i++){
            //cut the given string and send the rest ahead
            char curr = given.charAt(i);
            if(alpha[curr - 'a'] == 1) continue;
            alpha[curr - 'a'] = 1; 

            String ngiven = given.substring(0, i) + given.substring(i + 1, given.length());
            permutation2SirVoid(ngiven, ans + curr);                        
        }
    }


    


}