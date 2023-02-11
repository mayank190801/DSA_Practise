import java.util.*;

//ATLAST IT GOT FUCKING SUBMIT WITH SIR CODE
//TRY IT ON YOUR OWN BOI, TRY IT WITH DIFFERENT METHODS AS WELL
class RandomizedCollection {

    HashMap<Integer, HashSet<Integer>>  ds; 
    List<Integer> list;
    public RandomizedCollection() {
        ds = new HashMap<>();
        list  = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean flag = false;
        if(!ds.containsKey(val) || ds.get(val).size() == 0 ){
            ds.put(val, new HashSet<>());
            flag = true;
        }
        list.add(val);
        ds.get(val).add(list.size()-1);
        return flag;
    }
    
    //this all could have been able to be possible with list tho
    //if i think hard enough, i might be able to find the mistake and shit
    public boolean remove(int val) {
        Set<Integer> set = ds.get(val);
        if(set == null || set.size() == 0){
            return false;
        }
        //this is not necessary, but get used to iterator and shit boi
        //this is very very important for the game
        //can i do it like that brother?????
        Iterator it = set.iterator();
        int idx = (int)it.next();
        
        ds.get(val).remove(idx);
        list.set(idx, list.get(list.size()-1));
        ds.get(list.get(idx)).add(idx);
        ds.get(list.get(idx)).remove(list.size()-1);
        list.remove((list.size()-1));
        
        return true;
    }
    
    public int getRandom() {
        //simple one liner function
        return list.get((int)Math.floor(Math.random()*list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */