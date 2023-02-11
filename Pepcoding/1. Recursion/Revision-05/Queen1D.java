import java.io.*;
import java.util.*;

public class Queen1D {

//   public static void main(String[] args) throws Exception {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     int nboxes = Integer.parseInt(br.readLine());
//     int ritems = Integer.parseInt(br.readLine());
//     combinations(1, nboxes, 0, ritems, "");
//   }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 0, ritems, 0);
  }


//   //current block, total block, selection so far, total selection
//   public static void combinations(int cb, int tb, int ssf, int ts, String asf){
//     if(cb > tb){
//         if(ssf == ts){
//             System.out.println(asf);   
//         }
//         return;
//     }

//     //now take or not
//     if(ssf < ts)
//         combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
//     combinations(cb + 1, tb, ssf, ts, asf + "-");
    
//   }

    //current item, total item, last box in which item went bruh  
    public static void combinations(int[] boxes, int ci, int ti, int lb){
        if(ci == ti){
          // System.out.println(Arrays.toString(boxes));
          StringBuilder sb = new StringBuilder();
          for(int i : boxes){
            sb.append(i == 1 ? 'i' : '-');
          }
          String ans = sb.toString();
          System.out.println(ans);
          return;
      }

      for(int i = lb; i < boxes.length; i++){
          if(ci < ti){
            boxes[i] = 1;
            combinations(boxes, ci + 1, ti, i + 1);
            boxes[i] = 0;
          }
      }
    }


}