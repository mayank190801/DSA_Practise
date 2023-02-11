class Tree
{

		class Pair{
		int val;
		int level;

		Pair(int val, int level){
			this.val = val;
			this.level = level;
		}

	}

    public ArrayList<Integer> diagonal(Node root)
    {
    	ArrayList<Pair> tans = new ArrayList<>();
    	helper(root, tans, 0);

    	//now here sort on the basis of leve
    	Collections.sort(tans, (a,b) -> a.level - b.level);
    	ArrayList<Integer> ans = new ArrayList<>();

    	for(Pair p : tans){
    		ans.add(p.val);
    	}

    	return ans;
    }

    public void helper(Node root, ArrayList<Pair> ans, int level){
    	if(root == null) return;

    	ans.add(new Pair(root.data, level));

    	helper(root.left, ans, level + 1);
    	helper(root.right, ans, level);
    }
}
