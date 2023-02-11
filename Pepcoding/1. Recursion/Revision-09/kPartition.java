import java.io.*;
import java.util.*;

public class kPartition {

	public static int counter = 1;
	public static void solution(int i, int n, int k, int blocksUsed, ArrayList<ArrayList<Integer>> ans) {
		
		//base case 
		if(i > n){
			//simply check if no one is empty - rssf could help us in that
			if(blocksUsed == k){
				System.out.print(counter + ".");
				for(int j = 0; j < k; j++){
					System.out.print(" [");	
					for(int l = 0; l < ans.get(j).size(); l++){
						System.out.print(ans.get(j).get(l));
						if(l != ans.get(j).size() - 1){
							System.out.print(", ");
						}
					}
					System.out.print("]");
				}
				System.out.println();
				counter++;
			}
			return;
		}

		//this is more important part i think
		for(int j = 0; j < k; j++){
			ArrayList<Integer> temp = ans.get(j);  
			if(temp.size() == 0){
				temp.add(i);  
				solution(i + 1, n, k,  blocksUsed + 1, ans);
				temp.remove(temp.size() - 1);
				break;
			}else{
				temp.add(i);  
				solution(i + 1, n, k,  blocksUsed , ans);
				temp.remove(temp.size() - 1);
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}

		//unique case should be taken first 
		ans.get(0).add(1);
		solution(2, n, k, 1, ans);
	}

}