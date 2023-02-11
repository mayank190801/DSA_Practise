import java.io.*;
import java.util.*;

public class palindromePartitioning {

	public static void solution(char[] strc, int idx, String asf , String str) {
		//now start from one to all
		if(idx == strc.length){
			System.out.println(asf);
			return;
		}

		int n = str.length();
		for(int i = idx; i < n; i++){
			if(palindromeCheck(idx, i, strc)){
				String add = "(" + str.substring(idx, i + 1) + ") ";
				solution(strc, i + 1, asf + add, str);
			}
		}
		
	}

	public static boolean palindromeCheck(int i , int j, char[] str){
		while(i <= j){
			if(str[i] != str[j]) return false;
			i++;
			j--;
		}
		return true;
	}


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str.toCharArray(), 0, "", str);
	}
		

}