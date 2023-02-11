import java.util.ArrayList;
import java.util.*;
import java.io.*;


public class E {

    public static TreeMap<Integer, Integer> map = new TreeMap<>();
    public static int counter = 0;
    public static void main(String[] args) {
        //learn treemap by heart, you still haven't done that bro
        add(39, 44);
        System.out.println(map);
        System.out.println(count());
        add(7, 10);  //bigger range than imagingation boss, please solve it for sure
        System.out.println(map);
        System.out.println(count());
        add(5,8);
        System.out.println(map);
        System.out.println(count());
        

    }

    //also don't forget to check for lower entry also
    //now the hardest part is to get the counter fucntion right no matter what
    //simply pretty hard
    public static void add(int left, int right) {
        if(map.containsKey(left)){
            int get = map.get(left);
            if(right <= get){
                //nothing
                //simple bitchy case boss
            }else{
                map.put(left, right);  //updated the key 
                //some counter would have increased here
                counter += (Math.abs(right - get ));
                
                while(map.higherEntry(left) != null){
                    int next = map.higherKey(left);
                    if(next <= right){
                        //merge them   
                        if(map.get(next) <= right){
                            //simply subtract this portion
                            // counter -= (Math.abs(next - map.get(next)) + 1);
                            //keep on moving
                            counter -= (Math.abs(map.get(next) - next) + 1);
                            map.remove(next);
                        }else{
                            counter -= (Math.abs(right - next) + 1);
                            map.put(left, Math.max(map.get(next), right));
                            map.remove(next); //do it for sure    
                            break;  
                        }

                        //now update the counter
                        //check this one
                        // counter += Math.abs(get - next);
                    }else{
                        //otherwise no problem
                        // counter += Math.abs(get - right) + 1;
                        break;
                    }    
                }
             
            }
        }else{
            //this case is annoying for sure
            //check for lower entry 
            if(map.lowerEntry(left) == null){
                //no issues
                map.put(left, right);
                counter += (Math.abs(right - left) + 1);
                
            }else{
                //otherwise check
                map.put(left, right);
                counter += (Math.abs(right - left) + 1);

                int lower = map.lowerKey(left);
                if(map.get(lower) >= left){
                    if(map.get(lower) >= right){
                        counter -= (Math.abs(right - left) + 1);
                        map.put(lower, Math.max(map.get(lower), right));
                        map.remove(left);
                    }else{
                        counter += (Math.abs(right - map.get(lower)));
                        map.put(lower, Math.max(map.get(lower), right));
                        map.remove(left);
                    }
                }else{
                    // map.put(left, right);
                }
            }

            while(map.higherEntry(left) != null){
                int next = map.higherKey(left);
                if(next <= right){
                    //merge them   
                    if(map.get(next) <= right){
                        //simply subtract this portion
                        // counter -= (Math.abs(next - map.get(next)) + 1);
                        //keep on moving
                        counter -= (Math.abs(map.get(next) - next) + 1);
                        map.remove(next);
                    }else{
                        counter -= (Math.abs(right - next) + 1);
                        map.put(left, Math.max(map.get(next), right));
                        map.remove(next); //do it for sure    
                        break;  
                    }

                    //now update the counter
                    //check this one
                    // counter += Math.abs(get - next);
                }else{
                    //otherwise no problem
                    // counter += Math.abs(get - right) + 1;
                    break;
                }    
            }
        }
    }
    
    public static int count() {
        return counter;
    }
    
}
