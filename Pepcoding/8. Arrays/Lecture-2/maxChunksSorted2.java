public class maxChunksSorted2{

    //WE WILL DO SIR METHOD IN THIS ONE
    //HIS ONE IS OFC MORE INITUATIVE FOR SURE (if first i would have seen that)
    //i would have solved it in this way onl

    //MAX MIN LOGIC Baby
    //this was pretty cool for sure too man!!!!!
    //HARD TO CLICK ON YOUR OWN
    //(core concept - sorted properties!!!! where would it's last position be????)
    //(think min and max concept now bois)

    public int maxChunksToSorted(int[] arr){
        //max min
        //max min
        int n = arr.length;
        int[] max = new int[arr.length];
        int[] min = new int[arr.length];

        int cmax = arr[0];
        for(int i= 0; i < n; i++){
            cmax = Math.max(cmax, arr[i]);
            max[i] = cmax;
        }

        int cmin = arr[n-1];
        for(int i= n-1; i >= 0; i--){
            cmin = Math.min(cmin, arr[i]);
            min[i] = cmin;
        }

        //now we have both max and min with us
        int count = 1;
        for(int i= 0; i < n-1; i++){
            if(max[i] <= min[i+1]) count++;
        }

        return count;
    }

}