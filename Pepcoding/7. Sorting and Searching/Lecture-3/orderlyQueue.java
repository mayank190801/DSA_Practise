import java.util.Arrays;

public class orderlyQueue {
    public static void main(String[] args) {
        
    }

    //brute force baby
    //How the fuck i am so good
    public String orderlyQueue(String s, int k) {

        char[] str = s.toCharArray();
        if(k > 1){
            Arrays.sort(str);
            String ans = String.valueOf(str);
            return ans;
        }

        //now simply rotate and check boi
        String ans = String.valueOf(str);
        for(int i= 0; i < s.length(); i++){
            rotate(str);
            String ns = String.valueOf(str);

            //comparison factor is very important
            //check if two strings which one is smaller
            //is > 0 , that means smaller for sure!!!!
            
            if(ans.compareTo(ns)>0){
                ans = ns;
            }
        }

        return ans;
    }

    public void rotate(char[] str){
        
        char first = str[0];
        for(int i= 0; i < str.length-1; i++){
            str[i] = str[i+1]; 
        }
        str[str.length-1] = first;
    }
    
}
