public class jumpGame3 {
    
    public static void main(String[] args) {
        
    }

    //succesfully ran with runtime of 4ms!!
    //beautifully used true and false in this algo for sure!!
    
    public static boolean canReach(int[] arr, int start) {
        //last mein ek linear loop
        int n = arr.length;
        int[] visited = new int[n];

        visited[start] = 1;
        return helper(arr, start, visited);
    }

    public static boolean helper(int[] arr, int curr, int[] visited) {
        
        if(arr[curr] == 0){
            return true; //simly no need to go further
        }
        //check both
        int jump = arr[curr];

        if(curr- jump >= 0){
            if(visited[curr - jump] == 0){
                visited[curr - jump] = 1;
                if(helper(arr, curr - jump, visited)) return true;
            }
        }

        if(curr +  jump < arr.length){
            if(visited[curr + jump] == 0){
                visited[curr + jump] = 1;
                if(helper(arr, curr + jump, visited)) return true;
            }
        }
    
        return false;  //keep moving forward
    }



}
