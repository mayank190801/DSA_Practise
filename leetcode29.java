public class leetcode29 {

    //this should be helpful in solving this problem - one problem daily stuff should be applied
    public static void main(String[] args) {
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++){
           String curr = strs[i];
           int j;
           for(j = 0; j < Math.min(curr.length(), sb.length()); j++){
              if(sb.charAt(j) != curr.charAt(j)) break;
           }
           sb.delete(j, sb.length());
        }
        return sb.toString();
    }
}
