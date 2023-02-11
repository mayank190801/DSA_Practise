
class Solution
{
    public String FirstNonRepeating(String A)
    {
       	//for every char first non repeat
       	Queue<Character> que = new ArrayDeque<>();
       	Map<Character, Integer> occur = new HashMap<>();

       	StringBuilder ans = new StringBuilder();

       	for(char ch : A.toCharArray()){

       		//first put this bad boi in 
       		occur.put(ch, occur.get(ch) + 1);
       		que.put(ch);

       		boolean found = false;
       		while(!que.isEmpty()){
       			char top = que.peek();
       			if(occur.get(top) == 1){
       				found = true;
       				break;
       			}else{
       				que.poll();
       			}
       		}

       		if(found){
       			ans.add(que.peek());
       		}else{
       			ans.add('#');
       		}
       	}

       	String fans = ans.toString();
       	return fans;
    }
}