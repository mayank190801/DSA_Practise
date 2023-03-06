public class leetcode1689 {
    public static void main(String[] args) {
        System.out.println(minPartitions("27346209830709182346"));
    }

    public static int minPartitions(String n){
        int ans = 0;
        for(int i = 0; i < n.length(); i++){
            int val = n.charAt(i) - '0';
            ans = Math.max(ans, val);
        }
        return ans;
    }



}
