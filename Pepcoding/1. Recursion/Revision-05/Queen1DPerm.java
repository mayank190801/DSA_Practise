import java.io.*;
import java.util.*;

public class Queen1DPerm{


	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int nboxes = Integer.parseInt(br.readLine());
	    int ritems = Integer.parseInt(br.readLine());
	    // permutations(new int[nboxes], 1, ritems);
	    permutations2(1, nboxes, new int[nboxes], 0, ritems, "");
    }

	//current item , total item
 	public static void permutations(int[] boxes, int ci, int ti){
    	if( ci > ti){
    		StringBuilder sb = new StringBuilder();
          	for(int i : boxes){
            	sb.append(i);
          	}
         	String ans = sb.toString();
            System.out.println(ans);
          
    		return;
    	}

	    for(int i= 0;i < boxes.length; i++){
	    	if(boxes[i] == 0){
	    		boxes[i] = ci;
	    		permutations(boxes, ci + 1, ti);
	    		boxes[i] = 0;
	    	}
		}
	}

	//current block , total block, select so far, total so far, answer so far
	//subsequence method so far according to me for sure	
    public static void permutations2(int cb, int tb, int[] items, int ssf, int ts, String asf){
    	//permutation using subsequence
    	if(cb > tb){
    		if(ssf == ts){
    			System.out.println(Arrays.toString(items));
    			System.out.println(asf);
    		}
    		return;
    	}

    	if(ssf < ts){
    		if(items[cb-1] == 0){
    			items[cb-1] = (ssf + 1);
    			permutations2(1, tb, items, ssf + 1, ts, asf + (ssf + 1));
    			items[cb-1] = 0;
    		}
    	}
    	permutations2(cb + 1, tb, items, ssf, ts, asf + 0);
	}


}




