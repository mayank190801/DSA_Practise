import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

    }

    public boolean duplicateBrackets(char[] str){
    	
    	int n = str.length;
    	int counter = 0;
    	for(int i= 0; i < n; i++){
    		char ch = str[i];
    		if(!(ch == '(' || ch == ')')) counter++;

    		if(ch == '('){
    			counter = 0;
    		}

    		if(ch == ')'){
    			if(counter == 0) return false;
    			counter = 0;
    		}
    	}

    	return true;
    }

}