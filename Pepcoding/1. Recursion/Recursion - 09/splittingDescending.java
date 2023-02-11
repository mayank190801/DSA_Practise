import java.util.ArrayList;

public class splittingDescending {
    public static void main(String[] args) {
        //let's think about this one for a second
        //similar to that one, let's give it a shot for sure
        //don't give up on this one brother
        String s = "050043";
        //let's think about it 
        ArrayList<Long> num = new ArrayList<>();
        boolean check = solve(s, 0, num);
        System.out.println(check);

    }

    public static boolean solve(String s, int index, ArrayList<Long> num){

        //base condition
        if(index == s.length()){
            if(num.size() >= 2){
                System.out.println(num);
                return true;
            }
            return false;
        }


        //faith in the recursino
        boolean res= false;
        for(int i = index; i < s.length(); i++){
            Long curr = Long.parseLong(s.substring(index,i + 1));

            if(curr > 10000000000000L){
                return false;
            }
            
            if(num.isEmpty() || num.get(num.size()-1) - curr == 1){
                num.add(curr);
                res = res ||  solve(s, i+1, num);
                if(res) return res;
                num.remove(num.size()-1);
            }
        }

        return res;

    }

}
