public class search2D2 {
    public static void main(String[] args) {
        
    }

    //IN TOTAL 3 method
    //Method-1 (m*n)        //search through all values
    //Method-2 (m*logn)     //go to every m, and binary search
    //Method-3 (m+n)        //stand on top-right , bottom-left (smaller\greater logic)

    //THE MOST BRILLIANT METHOD FOR THIS QUESTION //greedy
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;

        int r = matrix.length;
        int c = j+1;

        while(i < r && j > -1){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }

        return false;
    }
}
