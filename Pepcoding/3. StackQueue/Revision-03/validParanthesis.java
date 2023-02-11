
//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
    	char[] str = s.toCharArray();   //for sure this should happen

    	//two different stacks bitches

    	Stack<Character> stc = new Stack<>();
    	Stack<Integer> sti = new Stack<>();

    	//after this we could do something in here
    	//that is we should traversing the string

    	for(char ch : str){
    		if(ch == '('){
    			stc.push('(');
    		}else{
    			//think a bit more
    			if(stc.isEmpty()){
    				stc.push(')');
    			}else{
    				
    				
    				if(stc.size() > 2){
    					char prev = stc.pop();
    					char prevprev = stc.pop();

    					if(prev == '('){
    						stc.push(prevprev);
    						stc.push('*');
    						sti.push(1);
    					}

    					if(prev == '*' && prevprev == '('){
    						stc.push('*');
    						sti.push(sti.pop() + 1);
    					}

    				}


    			}

    		}
    	}


    }


};