import java.util.*;
import java.io.*;
import java.awt.Point;


public class arrayQ{

    //First Part
    public static void printArr(int[] arr, int index){
        if(index+1 == 0) return;
        System.out.println(arr[index]);
        printArr(arr, index-1);
    } 

    //Second question(my version)
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void indexes(int[] arr , int val, int index){
        if(index == arr.length){
            return;
        }

        if(arr[index] == val){
            list.add(index);
        }
        indexes(arr,val,index+1);
    }

    //Third Question(Sir Version)
    //Brilliant
    //Divided into two parts
    //first count them, create the list
    //then return and place the indexes in that array
    public static int[] solve(int[] arr , int val, int index, int size){
       
        if(index == arr.length){
            return new int[size];
        }

        if(arr[index] == val) size++;

        int[] temp = solve(arr, val, index+1, size);
        
        if(arr[index] == val){
            temp[size-1] = index;
        }

        return temp;
    }
    

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int[] arr = {3,2,3,4,5,3};
        printArr(arr, arr.length-1);

        indexes(arr, 3, 0);
        System.out.println(list);

        int[] ans =solve(arr,3,0,0);
        System.out.println(Arrays.toString(ans));

    }
    
}
