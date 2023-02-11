import java.util.*;
import java.io.*;

public class kthGrammar {

	public static void main(String[] args){
		int ans = kthGrammar(3,4);
		System.out.println(ans);
	}

	//1 indexed boss
    public static int kthGrammar(int n, int k) {
    	if(n == 1){
    		return 0;
    	}

    	//otherwise 
    	int pos = k/2;
    	if(k%2 == 1) pos++;

    	int get = kthGrammar(n - 1, pos);

    	if(k % 2 == 1){
    		return get;
    	}else return get == 1 ? 0 : 1;
    }
}