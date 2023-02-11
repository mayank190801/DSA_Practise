import java.util.*;

//implement iterable later on to be added on this generic hashmap coded by us
//pretty dope according to me, heheheh
public class genericHashMap<Key, Value>{
    public class HMNode{
        Key key = null;
        Value value = null;

        public HMNode(Key key,Value value){
            this.key = key;
            this.value = value;
        }
    }

    //actual hashmap of array of linkedlist
    //learn this bitch
    LinkedList<HMNode>[] buckets;
    Integer size = 0;

    //constructor
    public genericHashMap(){
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
    public Value put(Key key,Value value){
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
    public Value get(Key key){
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
    public Value getOrDefault(Key key, Value defaultVal){
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
    public Value remove(Key key){
        int idx = getHashCode(key);
        LinkedList<HMNode> group = buckets[idx];
        
        boolean contains = containsKey(key);
        if(contains){
            Value ans = group.getFirst().value;
            group.removeFirst();
            size--;
            return ans;
        }

        return null;
    }

    //size
    public int size(){
        return size;
    }

    //containskey
    //function for contains key
    //pretty dope
    public boolean containsKey(Key key){
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
    public ArrayList<Key> keySet(){
        ArrayList<Key> ans = new ArrayList<>();
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
    public Integer getHashCode(Key key){
        Integer hc = key.hashCode();
        //why usinng buckets.lenght and not size is important to know for sure
        //backup sucks right now, try to be extremely better boi
        return Math.abs(hc)%buckets.length;
    }

    //rehashing
    //pretty basic concept for increasing hashmap buckets numbers only
    //only that much baby 
    public void rehash(){
        LinkedList<HMNode>[] temp = buckets;
        initialize(temp.length*2);
        for(int i = 0; i < buckets.length; i++){
            LinkedList<HMNode> group = temp[i];
            int size = group.size();
            while(size -- > 0){
                HMNode first = group.getFirst();
                this.put(first.key, first.value);
                group.removeFirst();
            }
        }
    }

    //sir wasn't probably able to teach this concept
    //you gotta figure this out on your own one day, and solve it
    //these are java indepths concept, so get yourself upto date with them
    //they are very important for sure

    // //iterator & iterable
    // @Override
    // public Iterator iterator() {
    //     //ni bna skte
    //     travel it = new travel();
    //     return it;
    // }

    // int i = 0;
    // int j = 0;

    // public class travel implements Iterator{
    //     @Override
    //     public boolean hasNext() {
    //         if(i == buckets.length){
    //             return false;
    //         }
    //         return true;
    //     }

    //     @Override
    //     public Key next() {

    //         while(i < buckets.length){
    //             if(buckets[i].size() == 0 || j == buckets[i].size()){
    //                 i++;
    //             }else{
    //                 j++;
    //             }
    //         }
    //         return i == buckets? -1 : buckets[i].get(j);
    //     }

    // }



}