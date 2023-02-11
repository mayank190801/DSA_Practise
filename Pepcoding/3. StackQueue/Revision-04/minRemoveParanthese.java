class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = 0;

        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++){
        	char ch = str[i];

        	if(ch == '('){
        		stack.push(i);
        		left++;
        	}

        	if(ch == ')'){
        		if(left > 0){
        			left--;
        			stack.pop();
        		}else{
        			right++;
        			stack.push(i);
        		}
        	}
        }

        //now we are done bois
        int[] pos = new int[s.length()];
        while(!stack.isEmpty()){
        	pos[stack.pop()] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
        	if(pos[i] == 0){
        		sb.append(str[i]);
        	}
        }

        return sb.toString();
        
    }
}