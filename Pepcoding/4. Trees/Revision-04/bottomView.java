class Solution
{
 
	static class Pair{
		Node node;
		int vc;

		Pair(Node node, int vc){
			this.node = node;
			this.vc = vc;
		}
	}

    //iterative
    static ArrayList<Integer> bottomView(Node root)
    {
    	ArrayList<Integer> ans = new ArrayList<>();
    	if(root == null) return ans;

    	int min = 0, max = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	Queue<Pair> que = new ArrayDeque<>();

    	que.add(new Pair(root, 0));
    	while(!que.isEmpty()){
    		int size = que.size();
    		while(size --> 0){
    			Pair top = que.poll();
    			Node node = top.node;
    			int vc = top.vc;

    			
    			map.put(vc, node.data);
				min = Math.min(vc, min);
    			max = Math.max(vc, max);
    			

    			if(node.left != null)
    				que.add(new Pair(node.left, vc - 1));

    			if(node.right != null)
    				que.add(new Pair(node.right, vc + 1));
    		}
    	}

    	for(int i = min; i <= max; i++){
    		ans.add(map.get(i));
    	}

    	return ans;
    }
}