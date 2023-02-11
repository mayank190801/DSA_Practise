import java.io.*;
import java.util.*;

class letterTile {

	//one solution is simple (distinct subseq, distinct perm) - definintely solvable for sure
	//ye toh ho jaana chahiye ab solve!! 

	//solve this smartly suppose
	//when all are visited simply print the solution no?
	public static void main(String[] args){
		numTilePossibilities("AAB");
	}

    public static int numTilePossibilities(String tiles) {

 		helper(tiles, 0, new boolean[tiles.length()], 0, "");
    	return 0;
    }

    //helper function for sure needed for this
    public static void helper(String tiles, int idx, boolean[] used, int count, String asf){
    	if(count == tiles.length()){	
    		System.out.println(asf);
    		return;
    	}

    	int n = tiles.length();
   		int[] alpha = new int[26];

    	for(int i = 0; i < n; i++){

    		char ch = tiles.charAt(i);

    		if(used[i]) continue;
    		if(alpha[ch-'A'] == 1){
    			count++;
    			continue;
    		};

    		//take or not take upto you!! for sure
    		alpha[ch-'A'] = 1;

    		//taking it 
    		ch = tiles.charAt(i);
    		used[i] = true;
    		helper(tiles, 0, used, count + 1, asf + ch);
    		used[i] = false;

    		//not taking it
    		helper(tiles, 0, used, count + 1, asf);

    	}

    	if(count == tiles.length()){
    		System.out.println(asf);
    	}
    }
}