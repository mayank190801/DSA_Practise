import java.util.*;

public class meetingRooms {
    public static void main(String[] args) {
        
    }
    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    //lol, this bad boi got accepted for sure man
    //MY METHOD FOR SURE 

    //USING PRIORITY QUEUE
    public int minMeetingRooms(List<Interval> intervals) {
        //sorting an priority queue ofc used in this question
        //pretty obvious for sure hence
        int max = 0;
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        int n = intervals.size();
        for(int i= 0; i < n; i++){
            //always remove first
            Interval curr = intervals.get(i);
            while(!pq.isEmpty()){
                if(pq.peek().end <= curr.start) pq.poll();
                else break;
            }

            pq.add(curr);
            max = Math.max(max, pq.size());
        }

        return max;
    }
    

    //SIR PRIORITY QUEUEU (Sir version of code bois)
    public int minMeetingRooms(int[][] arr) {
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));

        //based on end time
        PriorityQueue<Integer> pq = new PriorityQueue<>();// for min end time
        pq.add(arr[0][1]);

        for (int i = 1; i < arr.length; i++) {
            int st = arr[i][0];
            int end = arr[i][1];
            int lmend = pq.peek();// last meeting end
            if (lmend <= st) {
                pq.poll();
                pq.add(end);
            } else {
                pq.add(end);
            }
        }

        return pq.size();
    }

    //USING ARRAYS ONLY
    // USING SORTING
    //PRETTY BETTER THAN PQ OPTION FOR SURE
    //A lil bit optmised for sure, that ans++ thingie was awesome
    //he did the same thing in the above shit tooooo!!!! You idiot
    //Only if was needed
    public int minMeetingRooms(List<Interval> intervals) {

        //convert that above piece i
        int[][] arr = new int[intervals.size()][2];
        for(int i= 0; i < intervals.size(); i++){
            arr[i][0] = intervals.get(i).start;
            arr[i][1] = intervals.get(i).end;
        }


        int[] st = new int[arr.length];
        int[] end = new int[arr.length];
        int i = 0;
        for (int[] ar : arr) {
            st[i] = ar[0];
            end[i] = ar[1];
            i++;
        }
        Arrays.sort(st);
        Arrays.sort(end);
        int ans = 0;
        i = 0;
        int j = 0;
        while (i < arr.length) {
            if (st[i] >= end[j]) {
                i++;
                j++;
            } else {
                i++;
                ans++;
            }
        }
        return ans;
    }
}
