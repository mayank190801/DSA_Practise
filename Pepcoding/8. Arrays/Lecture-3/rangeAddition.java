public class rangeAddition {

    //SIR APPROACH
    //(same approach, but do it opposite manner)
    //(Go from start to end, simply same logic)

    //MY METHOD (do for each value, substract and add)
    //(then simply traverse the array from the end, simple as that)
    //O(updates) + O(arr.length)

    public int[] getModifiedArray(int length, int[][] updates) {
        //let's try to code it with our own method bois
        int[] ans = new int[length];
        for(int i = 0; i < updates.length; i++){
            int st = updates[i][1];
            ans[st] += updates[i][2];

            int end = updates[i][0];
            if(end == 0) continue;
            ans[end-1] -= updates[i][2];
        }

        int csum = 0;
        for(int i = length-1; i >= 0; i--){
            csum += ans[i];
            ans[i] = csum;
        }

        return ans;
    }
    
}
