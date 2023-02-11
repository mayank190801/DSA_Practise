import java.util.*;

public class combinationSum3{
	public static void main(String[] args){
		var answer = combinationSum3(3, 9);
		System.out.println(answer);
	}

	//simple baby
	//k numbers that sum up to n
	public static  List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> fans = new ArrayList<>();
		List<Integer> cans = new ArrayList<>();

		helper(k, n, fans, cans, 1);

		for(List<Integer> ca : fans){
			System.out.println(ca);
		}

		return fans;
	}

    public static void helper(int taken, int tar, List<List<Integer>> fans, List<Integer> cans, int last){

    	if(taken == 0){
    		if(tar == 0)
    			fans.add(new ArrayList<>(cans));
    		return;
    	}

    	for(int i = last; i <= 9; i++){
    		if(tar - i < 0) break;
    		cans.add(i);
    		helper(taken - 1, tar - i, fans, cans, i + 1);
    		cans.remove(cans.size() - 1);
    	}
    }

}