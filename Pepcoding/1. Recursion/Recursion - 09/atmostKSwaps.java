import javax.swing.plaf.synth.SynthScrollBarUI;

// import org.graalvm.compiler.nodes.extended.StateSplitProxyNode;

public class atmostKSwaps {

    public static String answer;

    public static void main(String[] args) {

        String s = "976764632";
        int k = 4;

        answer = s;
        char[] given = s.toCharArray();

        solve(given, k, 0);
        System.out.println(answer);

    }

    public static void compare(String given){
        for(int i = 0; i < given.length(); i++){
            if(given.charAt(i) - '0' > answer.charAt(i) -'0'){
                // System.out.println("true");
                answer = given;
                return;
            }else if(given.charAt(i) - '0' < answer.charAt(i) -'0'){
                return;
            }
        }
    }

    public static void swap(char[] given, int left, int right){
        char temp = given[left];
        given[left] = given[right];
        given[right] = temp;
    }

    public static void solve(char[] given, int k, int index){

        if(k >= 0){
            String current = String.valueOf(given);
            System.out.println(current);
            compare(current);
            if(k == 0)
                return;
        }

        //this shit is never taking place your honours to be honest
        for(int j = index; j < given.length ; j++){
            for(int i = j+1 ; i < given.length; i++){
                if(given[j] - '0' < given[i] -'0'){
                    swap(given, j, i);
                    solve(given, k-1, j+1);
                    swap(given, j, i);
                }
            }
        }
    

        return;
    }
    
}
