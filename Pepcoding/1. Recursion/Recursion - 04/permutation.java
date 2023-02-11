import java.util.*;
import java.io.*;
import java.awt.Point;


public class permutation{

    public static void swap(char[]inp, int first, int second){
        char temp = inp[first];
        inp[first] = inp[second];
        inp[second] = temp;
    }

    // void type for different
    //Sir had a different way for this
    //in which we keep cutting the string again and again and then 
    //adding the char
    public static void perm1(char[] inp, int index){

        //swap and move on
        if(index == inp.length){
            System.out.println(Arrays.toString(inp));
            return;
        }

        //simple question, very very simple man
        for(int i = index ; i < inp.length; i++){
            swap(inp, index, i);
            perm1(inp, index+1);
            swap(inp, index, i);
        }

    }

    //sir void way of doing this permutation
    //think and try doing it on your own
    public static void perm1_sir_void(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i= 0; i < str.length(); i++){
            //take one char append it to ans and then move on
            String temp = str.substring(0, i) + str.substring(i+1);
            perm1_sir_void(temp, ans + str.charAt(i));
        }

    }
    
    //return type for different
    public static List<String> perm1_(String inp, int index){

        if(index == inp.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
    
        ArrayList<String> answer = new ArrayList<>();
        var list = perm1_(inp, index+1);
        //now travel on this list
        char curr = inp.charAt(index);
        //simple logic
        for(String s : list){
            for(int i = 0; i <= s.length(); i++){
                answer.add( s.substring(0,i) + curr + s.substring(i));
            }
        }

        return answer;
    }

    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////


    //void type for similar 

    //with sir method first
    //then i will try to make changes my version
    public static void perm2_sir_void(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        //if that is appended once , then do it again, otherwise cause similarties
        //or array with boolean, whatever you want, you can do it to check for this case
        Set<Character> set = new HashSet<>();

        for(int i= 0; i < str.length(); i++){
            //take one char append it to ans and then move on
            if(set.contains(str.charAt(i))) continue;
            set.add(str.charAt(i));

            String temp = str.substring(0, i) + str.substring(i+1);
            perm2_sir_void(temp, ans + str.charAt(i));
        }

    }

    //void type for similiar (my version)//the one i learned at coding blocks
    //logic was pretty much same, hehehe
    public static void perm2(char[] inp, int index){

        //swap and move on
        if(index == inp.length){
            System.out.println(Arrays.toString(inp));
            return;
        }

        //just don't swap if already happened once  
        Set<Character> set = new HashSet<>();
        //simple question, very very simple man
        for(int i = index ; i < inp.length; i++){

            if(set.contains(inp[i])) continue;
            set.add(inp[i]);

            swap(inp, index, i);
            perm2(inp, index+1);
            swap(inp, index, i);
        }

    }

    //return type for similar
    //now using return type we might have to think how to do it

    //this we would have to figure out on our own
    //bitch
    //let's think



    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s1 = "abc";
        String s2 = "aab";

        // perm1_sir_void("abc", "");
        // perm2_sir_void("abab", "");
        perm2("abab".toCharArray(), 0);

        // perm1(s1.toCharArray(), 0);
        // var ans = perm1_(s1, 0);
        // System.out.println(ans);

    }
    
}
