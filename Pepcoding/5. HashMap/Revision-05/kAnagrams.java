//User function template for JAVA
import java.util.*;
import java.io.*;

public class kAnagrams {

	public static void main(String[] args){
		
		String s1 = "ukdbgygrsjlaukwsgc";
		String s2 = "memdwhetaewfahkc";
		int k = 14;

		areKKAnagrams(s1, s2, k);
		// areKAnagrams(s1, s2, k);
	}

	static boolean areKKAnagrams(String str1, String str2,
                                                 int k)
    {
        // If both strings are not of equal
        // length then return false
        int n = str1.length();
        if (str2.length() != n)
            return false;
 
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int count = 0;
        
        // Store the occurrence of all characters
        // in a hash_array
        for (int i = 0; i < n; i++)
            count1[str1.charAt(i) - 'a']++;
        for (int i = 0; i < n; i++)
            count2[str2.charAt(i) - 'a']++;
 
        // Count number of characters that are
        // different in both strings
        for (int i = 0; i < 26; i++)
            if (count1[i] > count2[i])
                count = count + Math.abs(count1[i] -
                                          count2[i]);

        System.out.println(count);
 
        // Return true if count is less than or
        // equal to k
        return (count <= k);
    }


    static boolean areKAnagrams(String s1, String s2, int k) {

    	int[] data = new int[26];
    	for(char ch : s1.toCharArray()){
    		data[ch-'a']++;
    	}

    	System.out.println(Arrays.toString(data));

    	int[] temp = new int[26];


    	for(char ch : s2.toCharArray()){
    		data[ch-'a']--;
    		temp[ch-'a']++;
    	}

    	System.out.println(Arrays.toString(data));

    	int total = 0;
    	int otherTotal = 0;
    	for(int i= 0; i < 26; i++){
    		total += Math.abs(data[i]);
    		otherTotal += data[i] > temp[i] ? data[i] - temp[i] : 0;
    	}

    	System.out.println(total);
    	System.out.println(otherTotal);

    	return k >= total/2;
    }


}