import java.io.*;
import java.util.*;

public class permWordTwo {

  public static void generateWords(int cc, String str, Character[] spots, 
    HashMap<Character, Integer> lastOccurence) {
    
        



  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Character[] spots = new Character[str.length()];
    HashMap<Character, Integer> lastOccurence = new HashMap<>();
    for(char ch: str.toCharArray()){
      lastOccurence.put(ch, -1);
    }

    generateWords(0, str, spots, lastOccurence);
  }

}