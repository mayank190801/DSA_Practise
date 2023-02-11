import java.util.Stack;

class Main
{

    //ser version of code for this question, pretty annoying
    //this code is not accurate, pls correct it for sure
    //otherwise it won't run babyyyyy
    //let's figure it out in the very next class
    public int maxDiffnsernsel(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.length; i++) {
            // how many elemets can be resolved by arr[i]
            int val = i == arr.length ? Integer.MIN_VALUE : arr[i];
            while (st.size() > 0 && arr[st.peek()] > val) {
                int nser = i == arr.length ? 0 : arr[i];
                st.pop();
                int nsel = st.size() == 0 ? 0 : arr[st.peek()];
                ans = Math.max(ans, Math.abs(nser - nsel));
            }
            st.push(i);
        }
        return ans;
    }




    //so this code actually works bro
    //i am literally smart for sure

    int findMaxDiff(int a[], int n)
    {
        //so i have n and the array for sure
        //i gotta make previous shit array int this 
        int[] prev = new int[n];
        Stack<Integer> stack = new Stack<>();

        int maxAns = 0;

        for(int i = 0; i <= n; i++){
            int val = i == n ? 0 : a[i];

            while(!stack.isEmpty() && a[stack.peek()] > val){
                //we gotta do some stuff here, that will change the world forever
                //when we are remvoing that element we will compare it with others
                int curr = stack.pop();
                maxAns = Math.max( Math.abs(prev[curr] - val) , maxAns);
            }

            if(!stack.isEmpty() && i != n){
                //if 
                if(a[stack.peek()] == val){
                    prev[i] = prev[stack.peek()];
                }else{
                    prev[i] = a[stack.peek()];
                }   
            }

            stack.add(i);
        }

        return maxAns;
    }
}