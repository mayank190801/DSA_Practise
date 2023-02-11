class Solution {

	//let's solve this problem no matter what
    public int scoreOfParentheses(String s) {  //level wise solve bois
    	int[] arr = new int[30];
    	int idx = 0;

    	for(char ch : s.toCharArray()){
    		if(ch == '('){	
    			idx++;
    		}else{
    			//hmmm no what
    			if(arr[idx] == 0){
    				arr[idx - 1]++;
    			}else{
    				arr[idx - 1] += arr[idx] * 2;
    				arr[idx] = 0;
    			}
    			idx--;
    		}
    	}

    	return arr[0];
    }


}