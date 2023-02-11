import java.util.*;

public class MyHashMap{
    public class HMNode{
        Integer key = 0;
        Integer value = 0;

        public HMNode(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
    }

    //actual hashmap of array of linkedlist
    //learn this bitch
    LinkedList<HMNode>[] buckets;
    Integer size = 0;

    //constructor
    public MyHashMap(){
        initialize(10);
    }

    public void initialize(int size){
        buckets = new LinkedList[size];
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }
    }

    //put
    //pretty dope
    public Integer put(Integer key, Integer value){
        //bucket index
        int idx = getHashCode(key);
        
        //does exist (first check this)??? 
        LinkedList<HMNode> group = buckets[idx];
        boolean contains = containsKey(key);

        //a bit more efficient way probably, let's see
        if(contains){
            group.getFirst().value = value;
        }else{
            HMNode node = new HMNode(key, value);
            group.addLast(node);
            size++;
        }

        return value;
    }

    //get 
    public Integer get(Integer key){
        //if contains or not, then remove
        int idx = getHashCode(key);
        LinkedList<HMNode> group = buckets[idx];
        
        boolean contains = containsKey(key);
        if(contains){
            return group.getFirst().value;
        }
        return null;
    }

    //get or default 
    public Integer getOrDefault(Integer key, Integer defaultVal){
        //if contains or not, then remove
        int idx = getHashCode(key);
        LinkedList<HMNode> group = buckets[idx];
        
        boolean contains = containsKey(key);
        if(contains){
            return group.getFirst().value;
        }
        return defaultVal;
    }


    //remove
    public Integer remove(Integer key){
        int idx = getHashCode(key);
        LinkedList<HMNode> group = buckets[idx];
        
        boolean contains = containsKey(key);
        if(contains){
            int ans = group.getFirst().value;
            group.removeFirst();
            size--;
            return ans;
        }

        return -1;
    }

    //size
    public int size(){
        return size;
    }

    //containskey
    //function for contains key
    //pretty dope
    public boolean containsKey(Integer key){
        int idx = getHashCode(key);
        LinkedList<HMNode> group = buckets[idx];

        //sir way of doing things, pretty tricky for sure, and annoying for sure
        //i don't like it very much for sure
        int size = group.size();
        while(size--> 0){
            if(group.getFirst().key == key){
                return true;
            }
            group.addLast(group.removeFirst());
        }
        return false;
    }

    //keyset
    public ArrayList<Integer> keySet(){
        ArrayList<Integer> ans = new ArrayList<>();
        //simple logic building only, how to access stuff and all
        for(int i = 0; i < buckets.length; i++){
            LinkedList<HMNode> cgroup = buckets[i];
            int size = cgroup.size();
            while(size -- > 0){
                ans.add(cgroup.getFirst().key);
                cgroup.addLast(cgroup.removeFirst());
            }
        }
        return ans;
    }

    //useful other functions we need to make for this purpose
    public Integer getHashCode(Integer key){
        Integer hc = key.hashCode();
        //why usinng buckets.lenght and not size is important to know for sure
        //backup sucks right now, try to be extremely better boi
        return Math.abs(hc)%buckets.length;
    }


}