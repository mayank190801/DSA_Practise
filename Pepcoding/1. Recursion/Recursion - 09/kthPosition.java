public class kthPosition {
    public static void main(String[] args) {
        //let's now think how to solve this one, baby
        //let's do this bitch
        int n = 5;
        int k = 13;
        k--;

        int answer = solve(n, k);
        System.out.println(answer);
    }

    //let's solve this question for int and shit for sure
    public static int solve(int n, int k){
        if(n == 1){
            return 0;
        }

        int len = (int)Math.pow(2, n-1);

        int answer;
        if(k >= len/2){
            answer = solve(n-1, k-len/2) == 1 ? 0 : 1;
        }else{
            answer = solve(n-1, k);
        }

        return answer;

    }
    
}
