class Solution {

	//google asked this problem last year bois!! (so be ready to solve it)
    public int[] asteroidCollision(int[] asteroids) {

    	//luckily the code does works but looks awful

    	Stack<Integer> stack = new Stack<>();   //simple and logical motherfucker
    	int n = asteroids.length;
		for(int i = 0; i < n; i++){
			int curr = asteroids[i];

			if(curr > 0){
				stack.push(curr);  //no worries
			}else{
				boolean saved = true;
				while(!stack.isEmpty()){
					int val = stack.peek();
					if(val > 0){
						if(val == -curr){
							stack.pop();
							saved = false;
							break;
						}else if(val > -curr){
							saved = false;
							break;
						}else{
							stack.pop();
						}
					}else break;
				}

				if(saved) stack.push(curr);
			}
		}    

		int[] answer = new int[stack.size()];
		int size = stack.size();
		for(int i = size - 1; i >= 0; i--){
			answer[i] = stack.pop();
		}

		return answer;

        
    }


}