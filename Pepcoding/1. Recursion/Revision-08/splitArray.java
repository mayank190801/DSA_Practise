import java.io.*;
import java.util.*;


public class splitArray {

	public static void main(String[] args){
		String curr = "1101111";
		var ans = splitIntoFibonacci(curr);
		System.out.println(ans);
	}

    public static List<Integer> splitIntoFibonacci(String num) {
    	List<Integer> ans = new ArrayList<>();
    	helper(num.toCharArray(), ans, 0);
    	return ans;
    }

    //helper function baby
    public static boolean helper(char[] num, List<Integer> numbers, int idx){
    	if(idx == num.length){
    		if(numbers.size() >= 3){
    			return true;
    		}
    		return false;
    	}
    
    	boolean res = false;    	
 		long current = 0;
    	long factor = 1;

    	for(int i = idx; i < num.length; i++){
    		long val = num[i] - '0';
    		current = current * 10  + val;

    		if(num[idx] == '0' && i != idx) break;

    		if(current > Integer.MAX_VALUE){
				break;
    		}

    			//one more check in here bass 
    		if(numbers.size() >= 2){
    			int f = numbers.get(numbers.size() - 2);
    			int s = numbers.get(numbers.size() - 1);

    			if(f + s != current) continue;
    		}

    			//otherwise
    		numbers.add((int)current);
    		res = res || helper(num, numbers, i + 1);
    		if(res) return res;
    		numbers.remove(numbers.size() - 1);
    	}
    
    	return res;
    }
}