
import java.util.*;
import java.io.*;

public class digitMulti {

	public static void main(String[] args){
		getSmallest((long)18);
	}

    static String getSmallest(Long N) {

    	int[] count = new int[10];
    	for(int i= 2; i <= 7; i++){
    		while(N % i == 0){
    			count[i]++;
    			N = N/i;
    		}
    	}

    	//simple 
    	if(N != 1){
    		return "-1";
    	}
    	
    	//2 and 3 se aise kuch kro
    	ArrayList<Integer> ans = new ArrayList<>();
    	int curr = 1;
    	for(int i = 9; i >= 0; i--){
    		while(count[i] != 0){
    			if(curr * i > 9){
    				ans.add(curr);
    				curr = i;
    			}else{
    				curr = curr * i;
    			}
    			count[i]--;
    		}
    	}
    	if(curr != 1){
    		ans.add(curr);
    	}

    	System.out.println(ans);
    	Collections.sort(ans);
    	StringBuilder sb = new StringBuilder();
    	for(int i : ans){
    		sb.append(i);
    	}
    	String fans = sb.toString();
    	return fans;
    }


};