import java.util.ArrayList;

public class subsequence {

    public static void main(String[] args) {
        //input like abc 
        char[] str = "abc".toCharArray();
        // subseq(str, 0, new StringBuilder());

        ArrayList<String> subs = subseqReturn(str, 0);
        System.out.println(subs);
    }

    //RETURN 
    public static ArrayList<String> subseqReturn(char[] str, int idx){        
        if(idx == str.length){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        //otherwise simply call for the ahead versino
        ArrayList<String> rec = subseqReturn(str, idx + 1);

        int fix = rec.size(); //don't update while it's happening 
        for(int i = 0; i < fix; i++){
            String get = rec.get(i);
            get = str[idx] + get;
            rec.add(get);
        }

        return rec;
    }

    //VOID  - simply print them
    public static void subseqVoid(char[] str, int idx, StringBuilder sb){

        if(idx == str.length){
            System.out.println(sb.toString());
            return;
        }

        //now  - don't
        subseqVoid(str, idx + 1, sb);
        
        //now  - do
        sb.append(str[idx]);
        subseqVoid(str, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        
    }
    
}
