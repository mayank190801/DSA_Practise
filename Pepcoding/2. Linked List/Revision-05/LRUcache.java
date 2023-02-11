class LRUCache {

	class dbNode{
		int key;
		int val;
		dbNode prev = null;
		dbNode next = null;

		dbNode(int key, int val){
			this.key = key;
			this.val = val;
		}

		@Override
		public String toString(){
			return val + "";
		}
	}

	public dbNode head;
	public dbNode tail;
	public int cap;
	public int size;

	public void addFirst(dbNode node){
		if(head == null){
			//proper db style stuff bruh
			head = node;
			tail = node;
		}else{
			head.prev = node;
			node.next = head;
			head = node;
		}
		size++;
	}

	public void removeFirst(){
		if(size == 0){
			return;
		}else if(size == 1){
			head = tail = null;
		}else{
			dbNode temp = head;
			head = head.next;
			head.prev = null;
			temp.next = null;
		}
		size--;
	}

	public void removeLast(){
		if(size == 0){
			return;
		}else if(size == 1){
			head = tail = null;  //simple no?
		}else{
			dbNode temp = tail;
			tail = tail.prev;
			tail.next = null;
			temp.prev = null;
		}
		size--;
	}

	public void removeNode(dbNode node){   //it will exist for sure
		if(head == node){
			removeFirst();
		}else if(tail == node){
			removeLast();
		}else{
			//simple piece of code for sure
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.prev = null;
			node.next = null;
			size--;
		}
	}

	
	//also need an hashmap
	public Map<Integer, dbNode> mapping;

    public LRUCache(int capacity) {
    	this.head = null;
    	this.tail = null;
    	this.size = 0;
    	this.cap = capacity;   //simple
    	this.mapping = new HashMap<>();  
    }
    
    public int get(int key) {
    	if(!mapping.containsKey(key)) return -1;

    	//if it exist
    	//get the listnode please
    	dbNode curr = mapping.get(key);
    	int ans = curr.val;

    	//now update everything in here boss
    	removeNode(curr);  
    	addFirst(curr);

    	return ans;
    }
    
    public void put(int key, int value) {

    	if(!mapping.containsKey(key)){
    		dbNode node = new dbNode(key, value);
    		mapping.put(key, node);
    		addFirst(node);

    		if(size > capacity){
    			dbNode last = tail;
    			int keyLast = last.key;
    			mapping.remove(keyLast);  
    			removeLast();
    		}
    		
    	}else{
    		dbNode curr = mapping.get(key);
    		curr.val = value;
    		removeNode(curr);
    		addFirst(curr);
    	}
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */