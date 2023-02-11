class Solution {

	//this is a good problem for sure! (try coding it brother! (and you will be good to go!! heheheh))
    public List<Integer> findAnagrams(String s, String p) {

    	//simply empty answer
    	if(s.length < p.length) return new ArrayList<>();

    	char[] s1 = s.toCharArray();
    	char[] s2 = p.toCharArray();

    	//premove answer
    	int[] one = new int[26];
    	int[] two = new int[26];

    	int count = 0;
    	int ccount = 0;

    	for(char ch : s2){
    		two[ch - 'a']++;
    		count++;
    	}

    	//now uptil that point for once
    	int i = 0;
    	for(i = 0; i < s2.length; i++){
    		one[s1[i] - 'a']++;
    		if(one[s1[i] - 'a'] <= two[s1[i] - 'a']){
    			ccount++;
    		}
    	}

    	ArrayList<Integer> ans = new ArrayList<>();
    	if(ccount == count){
    		ans.add(0);
    	}

    	//after this
    	int k = s2.length;
    	while(i < s1.length){
    		//include 
			one[s1[i] - 'a']++;
    		if(one[s1[i] - 'a'] <= two[s1[i] - 'a']){
    			ccount++;
    		}

    		//exclude
			one[s1[i-k] - 'a']++;
    		if(one[s1[i-k] - 'a'] <= two[s1[i-k] - 'a']){
    			ccount--;
    		}

    		if(ccount == count){
    			ans.add(i);
    		}

    		i++;
    	}

    	return ans;
    }

}