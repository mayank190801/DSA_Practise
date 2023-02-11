import java.io.*;
import java.util.*;

public class cryptoArithmetic {

    //Different styles but pretty much same question for sure boss
    //why use map, when you can use int[] arr, pretty sensible for sure
    //that makes it more dooable
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    // String s1 = scn.nextLine();
    // String s2 = scn.nextLine();
    // String s3 = scn.nextLine();

    String s1 = "team";
    String s2 = "pep";
    String s3 = "toppr";

    //team
    //pep
    //toppr
    solution(s1, s2, s3);

  }

  
  public static void solution(String s1, String s2, String s3) {
        //simple question
        //first find all the unique characters to map
        Set<Character> set = new HashSet<>();
        for(char ch : s1.toCharArray()){
            set.add(ch);
        }

        for(char ch : s2.toCharArray()){
            set.add(ch);
        }

        for(char ch : s3.toCharArray()){
            set.add(ch);
        }

        //now i have all the characters who i have to assign some value!! (and after all are assigned simply check it the answer is possible or not)
        //now get a hashmap or something for easier updating and assignment
        String unique = "";
        for(char ch : set){
            unique += ch;
        }
        
        // System.out.println(unique);
        solver(0, unique.toCharArray(), new HashMap<>(), s1, s2, s3, new int[10]);

  }

  public static void solver(int idx, char[] unique, HashMap<Character, Long> map, String s1, String s2, String s3, int[] num){
    //first assign the char at this idx
    if(idx >= unique.length){
        //check if the answer is correct or not
        //write a function for this bad bois
        long val1 = stringValue(s1, map);
        long val2 = stringValue(s2, map);
        long val3 = stringValue(s3, map);

        if(val1 + val2 == val3){
            System.out.println(map);
        }

        return;
    }

    //value could be assigned from 0 to 9
    for(int i = 0; i <= 9; i++){
        if(num[i] != 0) continue;
        map.put(unique[idx], (long)i);
        num[i] = 1;
        solver(idx + 1, unique, map, s1, s2, s3, num);
        num[i] = 0;
        map.remove(unique[idx]);
    }
  }

  public static long stringValue(String s, HashMap<Character, Long> map){
        long ans = 0;
        long curr = 1;
        for(int i= s.length() - 1; i >= 0; i--){
            long get = map.get(s.charAt(i));
            ans += get * curr;
            curr = curr * 10;
        }
        return ans;
  }




}
