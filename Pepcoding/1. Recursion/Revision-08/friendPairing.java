import java.io.*;
import java.util.*;

public class friendPairing {
  static int counter = 1;

  //some format is given to us, so solve accordingly boss! (recursion should be revised asap)
  public static void solution(int i, int n, boolean[] used, String asf) {
	//single digit answer
	while(i <= n && used[i]) i++;
	if(i > n){
		System.out.println(counter + "." + asf);
		counter++;
		return;
	}

	//otherwise we will probably land at some good piece for sure
	//single value answers bro
	used[i] = true;
	solution(i + 1, n, used, asf + "(" + i + ") ");
	used[i] = false;

	//double pairing answer
	for(int j = i + 1; j <= n; j++){
		if(used[j]) continue;
		used[j] = true;
		solution(i + 1, n, used, asf + "(" + i + "," + j +  ") ");
		used[j] = false;
	}
    
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    solution(1, n, used, "");
  }
}
