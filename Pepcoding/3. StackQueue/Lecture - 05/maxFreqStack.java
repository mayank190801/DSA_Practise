import java.util.HashMap;
import java.util.Stack;

class FreqStack {

    //this is important
    HashMap<Integer, Integer> fmap = new HashMap<>();
    HashMap<Integer, Stack<Integer>> design = new HashMap<>();

    public FreqStack() {
        
    }
    
    //pretty complicated shit for sure
    //i really don't think so this is the best approach to solve this
    //question for sure, then i woul have to figure out a better way
    //to solve these questions to make me extreme better at coding 
    //this person has spent some time in solving this problem

    public void push(int val) { 
        //what the fuck is getOrDefault for this case?
        //think about this one for sure, please think about this one
        fmap.put(val, fmap.getOrDefault(val, 0) + 1);
        int f = fmap.get(val);

        if(!design.containsKey(f)){
            design.put(f, new Stack<>());
        }

        //both works for sure
        //pretty simple not complicated for sure
        design.get(f).push(val);
    }
    
    public int pop() {
        //interesting motherfucker for sure
        //size of design is gonna give us everthi
        int mfreq = design.size();
        int ans = design.get(mfreq).pop();

        //if this got empty and shit????
        if(design.get(mfreq).size() == 0){
            design.remove(mfreq);
        }

        fmap.put(ans, fmap.get(ans)-1);
        //simple as that bois
        if(fmap.get(ans) == 0) fmap.remove(ans);
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */