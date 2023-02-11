

class Solution
{
    int findMaxDiff(int a[], int n)
    {
		int fans = 0;
		Stack<Integer> stack = new Stack<>();

		for(int i= 0; i <=n; i++){
			int val = i == n ? Integer.MIN_VALUE : a[i];

			boolean checker = false;
			while(!stack.isEmpty() && a[stack.peek()] >= val){
				if(a[stack.peek()] == val){
					checker = true;
					break;
				}
				int nser = i == n ? 0 : a[i];
				int idx = stack.pop();
				int nsel = stack.isEmpty() ? 0 : a[stack.peek()];
				fans = Math.max(fans, Math.abs(nser - nser));
			}

			if(!checker)
				stack.push(i);  //store indices brother
		}
		
		return fan
    }

    //how to handle same elements?
}