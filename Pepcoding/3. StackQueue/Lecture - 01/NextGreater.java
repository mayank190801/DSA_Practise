import java.io.*;
import java.util.*;

//this below is basically how we write code for one question, and are able to solve all other fours
//this is brilliant way of solving things, and i should focus on doing it and putting it ahead of me
//that's my goal

public class NextGreater{

    //next greater element on the right
    public static int[] nger(int[] arr){

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        
        for(int i= 0; i <= arr.length; i++){
            int val = i == arr.length ? Integer.MAX_VALUE : arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] < val){
                int index = stack.pop();
                ans[index] = i == arr.length ? -1 : i;
            }

            stack.push(i);
        }

        //simly replacing the indexes with actual values
        for(int i= 0; i < ans.length; i++){
            if(ans[i] != -1){
                ans[i] = arr[ans[i]];
            }
        }
        return ans;
    }

    //next smaller element on the right
    public static int[] nser(int[] arr){

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        
        for(int i= 0; i <= arr.length; i++){
            int val = i == arr.length ? Integer.MIN_VALUE : arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] > val){
                int index = stack.pop();
                ans[index] = i == arr.length ? -1 : i;
            }

            stack.push(i);
        }

        for(int i= 0; i < ans.length; i++){
            if(ans[i] != -1){
                ans[i] = arr[ans[i]];
            }
        }
        return ans;
    }

    //next larger element on the left
    public static int[] ngel(int[] arr){

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        
        for(int i= arr.length -1; i >= -1; i++){
            int val = i == -1? Integer.MAX_VALUE : arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] < val){
                int index = stack.pop();
                ans[index] = i == -1 ? -1 : i;
            }

            stack.push(i);
        }

        for(int i= 0; i < ans.length; i++){
            if(ans[i] != -1){
                ans[i] = arr[ans[i]];
            }
        }
        return ans;
    }

    //next smaller element on the left
    public static int[] nsel(int[] arr){

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        
        for(int i= arr.length -1; i >= -1; i++){
            int val = i == -1? Integer.MIN_VALUE : arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] > val){
                int index = stack.pop();
                ans[index] = i == -1 ? -1 : i;
            }

            stack.push(i);
        }

        for(int i= 0; i < ans.length; i++){
            if(ans[i] != -1){
                ans[i] = arr[ans[i]];
            }
        }
        return ans;
    }
}