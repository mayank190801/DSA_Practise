import java.io.*;
import java.util.*;

public class crossWord {

  public static void solution(char[][] arr, String[] words, int vidx) {
    //remember the steps and you are good to go brother
    //traverse first word
    //traverse all possible position
    //if placedhorizontally
    //placeHorizontally
    //removehorizaotally
    
    //if placedverticl
    //same
    //same

    //answer found bois
    if(vidx == words.length){
        print(arr);
        return;
    }

    //should be coded in 5-10 minutes, speed go bois
    // boolean checker = checkWordPlaceHorizontally(0, 1, words[0], arr);
    // System.out.println(checker);
    // boolean schecker = checkWordPlaceVertically(0, 1, words[0], arr);
    // System.out.println(schecker);

    int n = arr.length;
    for(int i= 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(words[vidx].charAt(0) == arr[i][j] || arr[i][j] == '-'){
                if(checkWordPlaceHorizontally(i, j, words[vidx], arr)){
                    boolean[] placed = placeWordHorizontally(i, j, words[vidx], arr);
                    solution(arr, words, vidx + 1);
                    unplaceWordHorizontally(i, j, placed, words[vidx], arr);
                }
    
                if(checkWordPlaceVertically(i, j, words[vidx], arr)){
                    boolean[] placed = placeWordVertically(i, j, words[vidx], arr);
                    solution(arr, words, vidx + 1);
                    unplaceWordVertically(i, j, placed, words[vidx], arr);
                }
            }
        }
    }
  }

  public static boolean checkWordPlaceHorizontally(int i, int j, String word, char[][] arr){
    //ek word pehla +
    //ek word baad + 
    //if not return false
    int n = arr.length;
    if(j-1 >= 0 && arr[i][j-1] != '+') return false;
    if(j + word.length() < n && arr[i][j + word.length()] != '+') return false;

    //now loop through this piece of code simple
    for(int k = j; k < j + word.length(); k++){
        if(k >= n) return false;  //simple out of the game 
        if(arr[i][k] == '-') continue;
        if(arr[i][k] == '+' || arr[i][k] != word.charAt(k - j)) return false; 
    }

    return true;
  }

  public static boolean checkWordPlaceVertically(int i, int j, String word, char[][] arr){
    
    int n = arr.length;
    if(i-1 >= 0 && arr[i-1][j] != '+') return false;
    if(i + word.length() < n && arr[i + word.length()][j] != '+') return false;

    //now loop through this piece of code simple
    for(int k = i; k < i + word.length(); k++){
        if(k >= n) return false;  //simple out of the game 
        if(arr[k][j] == '-') continue;
        if(arr[k][j] == '+' || arr[k][j] != word.charAt(k - i)) return false; 
    }

    return true;
  }

  public static boolean[] placeWordHorizontally(int i, int j, String word, char[][] arr){
    boolean[] placed = new boolean[word.length()];

    for(int k = j; k < j + word.length(); k++){
        if(arr[i][k] == '-'){
            placed[k - j] = true;
            arr[i][k] = word.charAt(k - j);
        }
    }

    return placed;
  }

  public static boolean[] placeWordVertically(int i, int j, String word, char[][] arr){
    boolean[] placed = new boolean[word.length()];

    for(int k = i; k < i + word.length(); k++){
        if(arr[k][j] == '-'){
            placed[k - i] = true;
            arr[k][j] = word.charAt(k - i);
        }
    }

    return placed;
  }

  public static void unplaceWordHorizontally(int i, int j, boolean[] placed, String word, char[][] arr){
      //simple function
        for(int k = j; k < j + word.length(); k++){
            if(placed[k - j]){
                arr[i][k] = '-';
            }
        }
    }

    public static void unplaceWordVertically(int i, int j, boolean[] placed, String word, char[][] arr){
        //simple function
        for(int k = i; k < i + word.length(); k++){
            if(placed[k - i]){
                arr[k][j] = '-';
            }
        }
    }

  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}