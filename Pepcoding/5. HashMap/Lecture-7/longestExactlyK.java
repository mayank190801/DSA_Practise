public class longestExactlyK {
    
    //EXACTLY K UNIQUE CHARACTERS

    //I could use hashmap or int array, both works, 
    //SIR used hashmap
    //I am using int[] map, both are working for sure cause logic is correct
    
    //LONGEST 
    //This one works perfectly for sure boi
    public int lengthOfLongestSubstring(String s, int k) {
         //let's try solving this bad boi
        int[] map = new int[300];

        int ans = 0;
        int clength = 0;
        int countDistinct = 0;

        int i= 0;
        int j= 0;

        while(i < s.length()){

            //EXTEND
            while(i < s.length()){
                char inc = s.charAt(i);
                int idx = inc;

                //update map
                if(map[idx]== 0) countDistinct++;
                map[idx]++;
                clength++;
                i++;

                //out of loop
                if(countDistinct > k) break;

                //answer check
                ans = Math.max(ans, clength);
            }

            //RELEASE
            while(j < i){
                char exc = s.charAt(j);
                int idx = exc;

                //some normal stuff
                map[idx]--;
                if(map[idx] == 0) countDistinct--;
                clength--;
                j++;

                if(countDistinct <= k) break;
            }
            
        }

        //if no substring exists return -1
        return ans == 0 ? -1 : ans;
    }
    

    //COUNT
    //SIMPLE AS THAT
    public int countOfExactlyK(String s, int k){
        return countOfAtmostSubstring(str,k) -  countOfAtmostSubstring(str,k-1);
    }


    public int countOfAtmostSubstring(String s, int k) {
        //let's try solving this bad boi
    int[] map = new int[300];

    int ans = 0;
    int clength = 0;
    int countDistinct = 0;

    int i= 0;
    int j= 0;

    while(i < s.length()){

        //EXTEND
        while(i < s.length()){
            char inc = s.charAt(i);
            int idx = inc;

            //update map
            if(map[idx]== 0) countDistinct++;
            map[idx]++;
            clength++;
            i++;

            //out of loop
            if(countDistinct > k) break;

            //answer check
            //I have to think about this check, i don't feel it is actually right
            //FIGURE THIS OUT
            ans += i-j;
        }

        //one hell of an OP testcase boi
        if(i == s.length() && countDistinct == k) break;

        //RELEASE
        while(j < i){
            char exc = s.charAt(j);
            int idx = exc;

            //some normal stuff
            map[idx]--;
            if(map[idx] == 0) countDistinct--;
            clength--;
            j++;

            if(countDistinct == k){
                    ans += i-j;
                    break;
            } 
        }
        
    }

    //if no substring exists return the length of string boi simple as that
    //we don't actually need to check this, and you know, cause ans checking point is already
    //checking all the k things for sure
    return ans;
    }
}
