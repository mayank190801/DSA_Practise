import java.io.*;
import java.util.*;

public class removeDuplicate {
    public static String removeDuplicateLetters(String s) {

    	//so basically if the letter is vis or not
    	//it's freq left
    	//current stack maybe
    	Stack<Character> st = new Stack<>();
    	int[] vis = new int[26];
    	Map<Character, Integer> freq = new HashMap<>();

    	for(char ch : s.toCharArray()){
    		freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    	}

    	//now we have the count
    	for(char ch : s.toCharArray()){

    		freq.put(ch, freq.get(ch) - 1);
    		if(vis[ch - 'a'] == 1) continue;
    		
    		while(!st.isEmpty() && st.peek() > ch && freq.get(st.peek()) > 0){
    			vis[st.peek() - 'a'] = 0;
    			st.pop();
    		}

    		st.push(ch);
    		vis[ch - 'a'] = 1;
    		//reduce the freq right fucking now!!

    	}

    	StringBuilder sb = new StringBuilder();
    	while(!st.isEmpty()){
    		sb.append(st.pop());
    	}

    	String ans = sb.reverse().toString();
    	return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = removeDuplicateLetters(read.readLine());
        System.out.println(result);
    }
}
