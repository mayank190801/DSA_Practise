import java.util.*;
import java.io.*;
import java.awt.Point;

public class permWordOne{

    static int mod = (int) (Math.pow(10, 9)+7);
	static final int dx[] = { -1, 0, 1, 0 }, dy[] = { 0, -1, 0, 1 };
	static final int[] dx8 = { -1, -1, -1, 0, 0, 1, 1, 1 }, dy8 = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static final int[] dx9 = { -1, -1, -1, 0, 0, 0, 1, 1, 1 }, dy9 = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static final int inf = Integer.MAX_VALUE / 2;
	static final long infL = Long.MAX_VALUE / 3;
	static final double infD = Double.MAX_VALUE / 3;
	static final double eps = 1e-10;
	static final double pi = Math.PI;
    static List<Integer> primeNumbers = new ArrayList<>();

    public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
        //this tells us to how many times a character exist in the hashmap
        //simple 
        if(cs == ts+1){
            System.out.println(asf);
            return;
        }

        for(char ch : fmap.keySet()){
            if(fmap.get(ch) <= 0) continue;
            fmap.put(ch, fmap.get(ch)-1);
            generateWords(cs+1, ts, fmap, asf+ch);
            fmap.put(ch, fmap.get(ch)+1);
        }
    }
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
    
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(char ch: str.toCharArray()){
          if(fmap.containsKey(ch)){
            fmap.put(ch, fmap.get(ch) + 1);
          } else {
            fmap.put(ch, 1);
          }
        }
    
        generateWords(1, str.length(), fmap, "");
    
    }
}

    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------

    //with mod
    