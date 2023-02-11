import java.util.ArrayList;

// stack logic 
//score parenthesis

class Solution {

    //using arraylist and shit
    //you could use something else too,
    //that is depth and array concept was super cool for sure
    //if inner depth pr hai kuch
    //linkedlist array depthh concept, whatever suits you
    //think you own logic bitch
    public int scoreOfParentheses(String s) {

        //o(1);
        ArrayList<Integer> list = new ArrayList<>();
    
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                list.add(0);
            }else{

                if(list.get(list.size()-1)== 0){
                    list.remove(list.size()-1);
                    list.add(1);
                }else{
                    int val = 0;
                    while(list.get(list.size()-1) != 0){
                        val += list.remove(list.size()-1);
                    }
                    list.remove(list.size()-1);
                    list.add(val*2);
                }
            //     int sum = 0;
            //     while(list.get(list.size()-1) != 0){
            //         sum += list.remove(list.size()-1);
            //     }
            //     //if 0 directly or 
            // list.remove(list.size()-1);
            //     if(sum == 0){
            //         list.add(1);
            //     }else{
            //         list.add(2*sum);
            //     }
            // }
            }
        }

        //end cases check krne ke liye
        int ans = 0;
        while(list.size() > 0){
            ans += list.remove(list.size()-1);
        }
        return ans;

    }
}