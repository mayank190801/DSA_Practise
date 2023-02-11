//User function Template for Java

class countRev
{
	public static void main(String[] args){
		int ans = countRev("}{}{}{}}}{{{{{}{}{}}{{}{}{}}{{}}{{");
	}

    public static int countRev (String s)
    {
        int left = 0;
        int right = 0;

        for(char ch : s.toCharArray()){
        	if(ch == '}'){
        		if(left > 0) left--; else right++;
        	}else{
        		left++;
        	}
        }

        int sum = left + right;
        if(sum % 2 == 1) return -1;

        int ans = Math.min(left, right) * 2 + Math.abs(left - right)/2;
        System.out.println(left + " " + right);
        return ans;
    }
}