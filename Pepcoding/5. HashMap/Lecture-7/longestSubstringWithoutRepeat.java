public class longestSubstringWithoutRepeat{
    //think of this one
    public static void main(String[] args) {
        
    }

    //we will do some variations of it in here
    //ALL DISTINCT
    //EXACTLY K DISTINCT
    //ATMOST K DISTICT
    //ALEAST K DISTINC

    //WITH 2 VARIATIONS OF EACH BOI
    //SUBSTRINGS WITH ALL DISTINCT CHARACTER

    //LONGEST SUBSTRING 
    public int lengthOfLongestSubstring(String s) {
        //let's try solving this bad boi
        int[] map = new int[300];

        int ans = 0;
        int clength = 0;

        int i= 0;
        int j= 0;

        while(i < s.length()){

            //EXTEND
            while(i < s.length()){
                char inc = s.charAt(i);
                int idx = inc;

                //update map
                map[idx]++;
                clength++;
                i++;

                //out of loop
                if(map[idx] > 1) break;

                //answer check
                ans = Math.max(ans, clength);
            }

            //RELEASE
            while(j < i){
                char exc = s.charAt(j);
                int idx = exc;

                //some normal stuff
                map[idx]--;
                clength--;
                j++;


                if(map[idx] == 1) break;
            }
            
        }

        return ans;
        
    }

    //COUNT FOR THE ABOVE TYPE
    public int countOfDistinctSubstring(String s) {
        //let's try solving this bad boi
        int[] map = new int[300];

        int ans = 0;
        int clength = 0;

        int i= 0;
        int j= 0;

        while(i < s.length()){

              //EXTEND
              while(i < s.length()){
                char inc = s.charAt(i);
                int idx = inc;

                //update map
                map[idx]++;
                clength++;
                i++;

                //out of loop
                if(map[idx] > 1) break;

                //answer check
                ans += i-j;
            }

            //RELEASE
            while(j < i){
                char exc = s.charAt(j);
                int idx = exc;

                //some normal stuff
                map[idx]--;
                clength--;
                j++;

                
                if(map[idx] == 1){
                    ans += i-j;
                    break;  
                } 
            }
        }

        return ans;
        
    }


}