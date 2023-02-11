
import java.util.*;
import java.io.*;

public class sameDiff{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test--> 0){
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++){
				arr[i] = sc.nextInt();
			}

			Map<Integer, Long> map = new HashMap<>();
			long count = 0;

			for(int i = 0; i < n; i++){
				int curr = arr[i] - i;
				count += map.getOrDefault(curr, 0L);
				map.put(curr, map.getOrDefault(curr, 0L) + 1L);
			}

			System.out.println(count);
		}



	}
}