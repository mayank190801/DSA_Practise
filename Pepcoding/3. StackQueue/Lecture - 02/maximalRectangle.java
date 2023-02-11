import java.util.Stack;

class Solution {

    public int largestAreaHistogram(int[] a){
        Stack<Integer> stack = new Stack<>();

        int max = 0;
        for(int i=  0; i <= a.length ; i++){
            int val = i == a.length ? Integer.MIN_VALUE : a[i];
    
            while(!stack.isEmpty() && a[stack.peek()] > val){
                int curr = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = i;
    
                int area = a[curr] * (rightIndex - leftIndex-1);
                max = Math.max(area, max);
            }
    
            stack.push(i);
        }
    
        return max;
    }

    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] arr = new int[m];

        int max = 0;
        for(int i= 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0) arr[j] = matrix[i][j]; 
                else{
                    if(matrix[i][j] == 0){
                        arr[j] = 0;
                    }else{
                        arr[j] = arr[j] +1;
                    }
                }
            }

            int currMax = largestAreaHistogram(arr);
            max = Math.max(max, currMax);
        }
        
        return max;
    }
}