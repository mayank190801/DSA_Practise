import java.util.*;
import java.io.*;

class splittingString {

	public static void main(String[] args){
		var ans = splitString("050043");
		System.out.println(ans);
	}

    public static boolean splitString(String s) {
    	long current = 0;
    	long factor = 1;
    	boolean res = false;
    	for(int i = 0; i < Math.min(s.length() - 1, 18); i++){
    		char ch = s.charAt(i);
    		long val = ch - '0';

    		current = current * 10 + val;
    		res = res || helper(s.toCharArray(), i + 1, current);
    		if(res) return res;
    	}

    	return false;
    }

    public static boolean helper(char[] s, int idx, long last){
    	if(idx == s.length){
    		return true;
    	}

    	//we can do that later on
    	int n = s.length;
    	long current = 0;
    	long factor = 1;

    	boolean res = false;

    	for(int i = idx; i < n; i++){
    		char ch = s[i];
    		long val = ch - '0';
    		
    		current = current * 10  + val;
    		if(current > last) break;

    		if(current == last - 1){
    			res = res || helper(s, i + 1, current);
    			if(res) return res;
    		}
    	}
    	
    	return res;
    }	

}
