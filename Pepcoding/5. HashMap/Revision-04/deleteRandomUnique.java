class RandomizedSet {

	HashMap<Integer, Integer> position;
	ArrayList<Integer> list;

    public RandomizedSet() {
    	position = new HashMap<>();
    	list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
    	if(position.containsKey(val)){
    		return false;
    	}

    	//now we know it aint's inside
    	position.put(val,list.size());
    	list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
		if(!position.containsKey(val)){
    		return false;
    	}

    	//now hmm, get the indexes simple
    	//pick the index and put it in the end, then return end
    	int idxc = position.get(val);
    	int idxe = list.size() - 1;

    	int vale = list.get(idxe);
    	//update pos for last element
    	position.put(vale, idxc);
    	position.remove(val);

    	list.set(idxc , vale);
    	list.remove(idxe);

       	return true;
    }

    
    public int getRandom() {
    	return list.get((int)(Math.random()* list.size()));
    }

}




/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
*/