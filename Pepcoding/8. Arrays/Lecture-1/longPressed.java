public class longPressed{
    public static void main(String[] args) {
        
    }

    //sir way of coding 
    //hopefully less code for sure
    //PRETTY FUCKING SIMILAR
    
    public boolean isLongPressedName(String name, String typed) {
        int p1=  0;
        int p2 = 0;

        while(p1 < name.length() && p2 < typed.length()){
            if(name.charAt(p1) == typed.charAt(p2)){
                p1++;
                p2++;
            }else{
                //not correct for all the cases
                if(p2 == 0 || typed.charAt(p2) != typed.charAt(p2-1)){
                    return false;
                }
                //skip similar
                while(p2 < typed.length()-1 && typed.charAt(p2) == typed.charAt(p2+1)){
                    p2++;
                }
                p2++;
            }
        }

        if(p2 == typed.length() && p1 != name.length()) return false;
        if(p1 == name.length()){
            while(typed.charAt(p2-1) == typed.charAt(p2)){
                p2++;
            }
        }
        
        return p2 == typed.length();

    }

    //let's simply think how logically to sovle a problem
    //damn, it got accepted in one go for sure, my brain is fresh right now
    //keep pushing your brain cells to make proper logic again and again for sure
    public boolean isLongPressedName(String name, String typed) {
        int up = 0;
        int down = 0;
        char last = '.';

        while(up < name.length() && down < typed.length()){
            if(name.charAt(up) == typed.charAt(down)){
                up++;
                last = typed.charAt(down);
                down++;
            }else{
                if(typed.charAt(down) == last){
                    last = typed.charAt(down);
                    down++;
                }else return false;
            }
        }

        boolean check = true;
        while(down < typed.length()){
            if(typed.charAt(down) != last){
                check= false;
                break;
            }
            last = typed.charAt(down);
            down++;
        }

        return up == name.length() && check;

    }


}