import java.util.*;

class cryptoVishal {
    public boolean isSolvable(String[] words, String result) {
        return helper(words,result);
    }
   
    public boolean helper(String[] words, String result){
        boolean map[]=new boolean[26];
        for (int i = 0; i < words.length; i++) {
            String str=words[i];
            for (int j = 0; j < str.length(); j++) {
                map[str.charAt(j)-'A']=true;
            }
        }
        for (int j = 0; j < result.length(); j++) {
            map[result.charAt(j)-'A']=true;
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <map.length; i++) {
            if(map[i]==true){
               // System.out.println(i);
                sb.append((char)(i+'A'));
            }
        }
     //   System.out.println(sb);
        int charMap[]=new int[26];
        Arrays.fill(charMap,-1);
        char intMap[]=new char[10];
        Arrays.fill(intMap,' ');
        boolean ans=crypto(words,sb.toString(),result,charMap,intMap,0);
    //    System.out.println(ans);
        return ans;
    }
    public boolean crypto(String words[],String unique,String result,int []charMap,char intMap[],int idx){
        if(idx==unique.length()){
            int arr[]=new int[words.length];
            
            for (int i = 0; i < words.length; i++) {
                String str=words[i];
                        if(str.length()>1){
             if(charMap[str.charAt(0)-'A'] == 0){return false;}
        }
                int num=generateInt(str,charMap);
                arr[i]=num;
            }
            int num2= generateInt(result,charMap);
            int num1=0;
            for (int i = 0; i < arr.length; i++) {
                num1+=arr[i];
            }
            // if(num1==0 || num2==0){
            //     return false;
            // }
            if(num1==num2){
                return true;
            }
            return false;
        }
        char ch=unique.charAt(idx);
        boolean res=false;
        for (int i = 0; i < 10; i++) {
            if(intMap[i]==' '){
                intMap[i]=ch;
                charMap[ch-'A']=i;
                res=res||crypto(words,unique,result,charMap,intMap,idx+1);
                intMap[i]=' ';
                charMap[ch-'A']=-1;
            }
        }
        return res;

    }
    public  int  generateInt(String str,int[] charMap){
        int ans=0;

        
        for (int i = 0; i < str.length(); i++) {
            ans=ans*10+charMap[str.charAt(i)-'A'];
        }
        return ans;
    }
    
}