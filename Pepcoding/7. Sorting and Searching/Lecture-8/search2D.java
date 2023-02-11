public class search2D{
    public static void main(String[] args) {
        
    }

    //LOGIC 
    //Always remember this shit
    //(r,c) -> (r*col + c);
    //idx -> (idx/col , idx%col)

    //THIS WORKS PERFECTLY, Just remember the conversions brother
    public boolean searchMatrix(int[][] matrix, int target) {
        //if exist return true
        int r = matrix.length;
        int c = matrix[0].length;

        int s = 0;
        int e = r*c-1;

        while(s <= e){
            int mid = (s+e)/2;
            int val = matrix[mid/c][mid%c];
            if( val == target){
                return true;
            }else if(val < target){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }

        return false;
    }

}